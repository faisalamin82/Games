package com.faisal.games.model;

public class Average {

	private String title;
	private int average_likes;
	
	public Average(String title, int average_likes) {
		this.title = title;
		this.average_likes = average_likes;
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAverage_likes() {
		return average_likes;
	}
	public void setAverage_likes(int average_likes) {
		this.average_likes = average_likes;
	}
}
