package br.com.udemy.api.security.jwt;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUser implements UserDetails {

    private static final long serialVersionUID = 1L;
    
    private final String id;
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> autorities;

    public JwtUser(String id, String username, String password, Collection<? extends GrantedAuthority> autorities){
        this.id = id;
        this.username = username;
        this.password = password;
        this.autorities = autorities;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

    @JsonIgnore
    @Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

    @JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

    @JsonIgnore
    @Override
	public boolean isAccountNonLocked() {
		return false;
	}

    @JsonIgnore
    @Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	/**
	 * @return the id
	 */
    @JsonIgnore
	public String getId() {
		return id;
	}
}