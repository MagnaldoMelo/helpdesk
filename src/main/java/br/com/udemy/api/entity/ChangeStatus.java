package br.com.udemy.api.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.udemy.api.enums.StatusEnum;

@Document
public class ChangeStatus{

    @Id
    private String id;

    @DBRef
    private Ticket ticket;

    @DBRef
    private User userChange;

    private Date dateChangeStatus;

    private StatusEnum status;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the ticket
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the userChange
	 */
	public User getUserChange() {
		return userChange;
	}

	/**
	 * @param userChange the userChange to set
	 */
	public void setUserChange(User userChange) {
		this.userChange = userChange;
	}

	/**
	 * @return the dateChangeStatus
	 */
	public Date getDateChangeStatus() {
		return dateChangeStatus;
	}

	/**
	 * @param dateChangeStatus the dateChangeStatus to set
	 */
	public void setDateChangeStatus(Date dateChangeStatus) {
		this.dateChangeStatus = dateChangeStatus;
	}

	/**
	 * @return the status
	 */
	public StatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
	} 
}