package com.faisal.games.model;

import java.util.List;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonbPropertyOrder({"title", "description", "by", "platform", "age_rating", "likes", "comments"})
public class GameTitle {
	
	
	private String title;
	private String description;	
	private String by;
	private List<String> platform;
	private String age_rating;
	private String likes;
	private List<Comment> comments;
	
	
	public GameTitle()
	{
		
	}
	
//	public GameTitle(String title, String description, String by, List<String> platform, String age_rating, String likes, List<Comment> comments)
//	{
//		this.title = title;
//		this.description = description;
//		this.by = by;
//		this.platform = platform;
//		this.age_rating = age_rating;
//		this.likes = likes;
//		this.comments = comments;
//		
//	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String descprition) {
		this.description = descprition;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public List<String> getPlatform() {
		return platform;
	}
	public void setPlatform(List<String> platform) {
		this.platform = platform;
	}
	public String getAge_rating() {
		return age_rating;
	}
	public void setAge_rating(String age_rating) {
		this.age_rating = age_rating;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString()
	{
		
		return new StringBuffer(" title : ").append(this.title)
                .append(" description : ").append(this.description)
                .append(" by : ").append(this.by)
                .append(" platform : ").append(this.platform)
                .append(" age_rating : ").append(this.age_rating)
                .append(" likes : ").append(this.by)
                .append(" comments : ").append(this.by).toString();
		
	}
	
	

}
