package br.com.udemy.api.controller;

import br.com.udemy.api.entity.ChangeStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.udemy.api.entity.Ticket;
import br.com.udemy.api.entity.User;
import br.com.udemy.api.enums.StatusEnum;
import br.com.udemy.api.response.Response;
import br.com.udemy.api.security.jwt.JwtTokenUtil;
import br.com.udemy.api.service.TicketService;
import br.com.udemy.api.service.UserService;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin(origins = "*")
public class TicketController{

    @Autowired
    private TicketService ticketService;

    @Autowired
    protected JwtTokenUtil jwbTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER')")
    public ResponseEntity<Response<Ticket>> create(HttpServletRequest request, @RequestBody Ticket ticket, BindingResult result){
        Response<Ticket> response = new Response<Ticket>();
        try {
            validadeCreateTicket(ticket, result);
            if (result.hasErrors()){
                result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(response);
            }
            ticket.setStatus(StatusEnum.getStatus("New"));
            ticket.setUser(userFromRequest(request));
            ticket.setDate((new Date()));
            ticket.setNumber(generateNumber());
			Ticket ticketPersisted = ticketService.createOrUpdate(ticket);
            response.setData(ticketPersisted);
        } catch(Exception e){
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    private void validadeCreateTicket(Ticket ticket, BindingResult result){
        if (ticket.getTitle()== null){
            result.addError(new ObjectError("Ticket", "Title on informed"));
            return;
        }
    }

    public User userFromRequest(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String email = jwbTokenUtil.getUsernameFromToken(token);
        return userService.findByEmail(email);
    }

    private Integer generateNumber(){
        Random random = new Random();
        return random.nextInt(9999);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER')")
    public ResponseEntity<Response<Ticket>> update(HttpServletRequest request, @RequestBody Ticket ticket, BindingResult result){
        Response<Ticket> response = new Response<Ticket>();
        try{
            validateUpdateTicket(ticket, result);
            if (result.hasErrors()){
                result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(response);
            }
            Ticket ticketCurrent = ticketService.findById(ticket.getId());
            ticket.setStatus(ticketCurrent.getStatus());
            ticket.setUser(ticketCurrent.getUser());
            ticket.setDate(ticketCurrent.getDate());
            ticket.setNumber(ticketCurrent.getNumber());
            if (ticketCurrent.getAssignedUser() != null){
                ticket.setAssignedUser(ticketCurrent.getAssignedUser());
            }
            Ticket ticketPersisted = ticketService.createOrUpdate(ticket);
            response.setData(ticketPersisted);
        } catch (Exception e){
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    private void validateUpdateTicket(Ticket ticket, BindingResult result){
        if (ticket.getTitle() == null){
            result.addError(new ObjectError("Ticket", "Title no informed"));
            return;
        }
        if (ticket.getId() == null){
            result.addError(new ObjectError("Ticket", "Id no informed"));
            return;
        }
    }

    @GetMapping(value = "{id}")
    @PreAuthorize("hasAnyRole('CUSTOMER', 'TECHNICIAN')")
    public ResponseEntity<Response<Ticket>> findById(@PathVariable("id") String id){
        Response<Ticket> response = new Response<Ticket>();
        Ticket ticket = ticketService.findById(id);
        if (ticket == null){
            response.getErrors().add("Register not found id: " + id);
            return ResponseEntity.badRequest().body(response);
        }
        List<ChangeStatus> changes = new ArrayList<ChangeStatus>();
        Iterable<ChangeStatus> changesCurrent = ticketService.listaChangeStatus(ticket.getId());
        for (Iterator<ChangeStatus> iterator = changesCurrent.iterator(); iterator.hasNext();){
            ChangeStatus changeStatus = iterator.next();
            changeStatus.setTicket(null);
            changes.add(changeStatus);
        }
        ticket.setChanges(changes);
        response.setData(ticket);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasAnyRole('CUSTOMER')")
    public ResponseEntity<Response<String>> delete(@PathVariable("id") String id){
        Response<String> response = new Response<String>();
        Ticket ticket = ticketService.findById(id);
        if (ticket == null){
            response.getErrors().add("Register not found id: " + id);
            return ResponseEntity.badRequest().body(response);
        }
        ticketService.delete(ticket); 
        return ResponseEntity.ok(new Response<String>());
    }
}