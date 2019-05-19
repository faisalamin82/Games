package com.faisal.games.model;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"user", "message", "dateCreated", "like"})
public class Comment {
	
	private String user;
	private String message;
	private String dateCreated;
	private String like;
	public Comment(String user) {
		this.user = user;
		
	}
	
	public Comment() {
		
		
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	
	@Override
	public String toString()
	{
		return new StringBuffer(" user : ").append(this.user)
        .append(" message : ").append(this.message)
        .append(" dateCreated : ").append(this.dateCreated)
        .append(" like : ").append(this.like).toString();
	}

}
