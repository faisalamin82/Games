package com.faisal.games;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.faisal.games.model.GameTitle;

@Path("{id}")
public class GameResource {

	GameRepository gameRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public GameTitle getTitle(@PathParam("id") long id) {
		GameRepository gameRepository = new GameRepository();

		return gameRepository.readJson(--id);
	}

	

}
