package com.faisal.games;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.faisal.games.model.Report;

@Path("report")
public class ReportResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Report getReport() {

		GameRepository game = new GameRepository();
		return game.generateReport();
	}

}
