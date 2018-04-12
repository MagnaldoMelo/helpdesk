package br.com.udemy.api.security.model;

import br.com.udemy.api.entity.User;

public class CurrentUser{

    private String token;
    private User user;

    public CurrentUser(String token, User user){
        this.setToken(token);
        this.setUser(user);
    }
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}