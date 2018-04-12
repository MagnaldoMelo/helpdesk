package br.com.udemy.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import br.com.udemy.api.security.jwt.JwtUser;

import br.com.udemy.api.entity.User;
import br.com.udemy.api.enums.ProfileEnum;

public class JwtUserFactory{

    private JwtUserFactory(){

    }

    public static JwtUser create(User user){
        return new JwtUser(user.getId(), user.getEmail(), user.getPassword(),
            mapToGrantedAuthorities(user.getProfile()));
    }

    public static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum){
        List<GrantedAuthority> autorities = new ArrayList<GrantedAuthority>();
        autorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
        return autorities;
    }
}