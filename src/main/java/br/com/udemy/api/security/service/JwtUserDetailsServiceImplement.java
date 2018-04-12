package br.com.udemy.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.udemy.api.entity.User;
import br.com.udemy.api.security.jwt.JwtUserFactory;
import br.com.udemy.api.service.UserService;

@Service
public class JwtUserDetailsServiceImplement implements UserDetailsService{

    @Autowired
    private UserService userService;
    
    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException(String.format("No user found with username '%'.", email));
        } else {
            return JwtUserFactory.create(user);
        }
	}

}