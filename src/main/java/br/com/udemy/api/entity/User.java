package br.com.udemy.api.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.udemy.api.enums.ProfileEnum;

@Document
public class User{

    @Id
	private String id;

    @Indexed(unique = true)
    @NotBlank(message = "E-mail required")
	@Email(message = "E-mail inválido")
	private String email;
	
	@NotBlank(message = "Password required")
	@Size(min = 6)
	private String password;
	
    private ProfileEnum profile;
	/**
	 * @return the profile
	 */
	public ProfileEnum getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}