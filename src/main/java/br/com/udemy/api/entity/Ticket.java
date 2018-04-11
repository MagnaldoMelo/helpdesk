package br.com.udemy.api.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.udemy.api.enums.PriorityEnum;
import br.com.udemy.api.enums.StatusEnum;



public class Ticket{

    @Id
    private String id;
    
    @DBRef(lazy = true)
    private User user;

    private Date date;
    
    private String title;
    
    private Integer number;

    private StatusEnum status;

    private PriorityEnum priority;
    
    @DBRef(lazy = true)
    private User assignedUser;
    
    private String description;
    
    private String image;
	
	@Transient
    private List<ChangeStatus> changes;
    
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
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	/**
	 * @return the assignedUser
	 */
	public User getAssignedUser() {
		return assignedUser;
	}
	/**
	 * @param assignedUser the assignedUser to set
	 */
	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
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
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the priority
	 */
	public PriorityEnum getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(PriorityEnum priority) {
		this.priority = priority;
	}
	/**
	 * @return the changes
	 */
	public List<ChangeStatus> getChanges() {
		return changes;
	}
	/**
	 * @param changes the changes to set
	 */
	public void setChanges(List<ChangeStatus> changes) {
		this.changes = changes;
	}
   

}