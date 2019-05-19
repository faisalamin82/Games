package com.faisal.games.model;

import java.util.List;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"user_with_most_comments", "highest_rated_game", "average_likes_per_game"})
public class Report {
	
	private String user_with_most_comments;
	private String highest_rated_game;
	private List<Average> average_likes_per_game;
	
	
	public String getUser_with_most_comments() {
		return user_with_most_comments;
	}
	public void setUser_with_most_comments(String user_with_most_comments) {
		this.user_with_most_comments = user_with_most_comments;
	}
	public String getHighest_rated_game() {
		return highest_rated_game;
	}
	public void setHighest_rated_game(String highest_rated_game) {
		this.highest_rated_game = highest_rated_game;
	}
	public List<Average> getAverage_likes_per_game() {
		return average_likes_per_game;
	}
	public void setAverage_likes_per_game(List<Average> average_likes_per_game) {
		this.average_likes_per_game = average_likes_per_game;
	}
	
	
	

}
