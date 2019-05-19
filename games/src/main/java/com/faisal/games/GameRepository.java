package com.faisal.games;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.faisal.games.model.Average;
import com.faisal.games.model.Comment;
import com.faisal.games.model.GameTitle;
import com.faisal.games.model.Report;

public class GameRepository {

	//private List<GameTitle> titles;

	/* This method reads the JSON file and parse the data for different fields
	 * and then creates the GameTitle object and returns it 
	 * */
	
	public GameTitle readJson(long ids) {
		GameTitle gameTitle = new GameTitle();

		try {

			JSONArray jsonArray = parseArray();

			int id = (int) ids;
			if (id >= jsonArray.size() || id <= 0)
				id = 0;

			JSONObject jsonObject = (JSONObject) jsonArray.get((int) id);
			gameTitle.setTitle((String) jsonObject.get("title"));
			gameTitle.setDescription((String) jsonObject.get("description"));
			gameTitle.setBy((String) jsonObject.get("by"));
			gameTitle.setAge_rating((String) jsonObject.get("age_rating"));

			gameTitle.setPlatform((List<String>) jsonObject.get("platform"));

			String likes = String.valueOf(jsonObject.get("likes"));

			gameTitle.setLikes(likes);
			gameTitle.setComments((List<Comment>) jsonObject
					.get("comments")); /* Date was not in epoch and did not need to convert it */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return gameTitle;
	}

	/* This method reads the JSON file and returns the ouput to the calling method(s)
	 */
	
	private JSONArray parseArray() throws FileNotFoundException, IOException, ParseException {
		URL url = getClass().getResource("games.json");
		File file = new File(url.getPath());

		FileReader reader = new FileReader(file);

		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
		return jsonArray;
	}

	/* This method consumes the map returned by getDataForReport method
	 * and then creates the Report object and returns it 
	 * */
	
	public Report generateReport() {
		
		Report report = new Report();
		JSONArray jsonArray = null;
		try {
			jsonArray = parseArray();
		} catch (IOException | ParseException e) {
			
			e.printStackTrace();
		}
		Map<String, List> data = getDataForReport(jsonArray);
		
		report.setAverage_likes_per_game(data.get("averageLikes"));
		List<String> ageRateData = data.get("rating");
//		Collections.sort(ageRateData);
//		String ageRate = ageRateData.get(ageRateData.size()-1);
		report.setHighest_rated_game((String) data.get("maxComment").get(1));
		report.setUser_with_most_comments((String) data.get("maxComment").get(0));
		
		return report;
	}

	/* This method reads the json array passed by parseArray method and parse the data for different fields
	 * and populates it in the Map and returns it to the generateReport method
	 * It gets highest rated game, returns the title of highest rated game and also average likes per game 
	 * */
	
	public Map<String, List> getDataForReport(JSONArray jsonArray)

	{
		List<String> users = new ArrayList<>();
		List<String> rating = new ArrayList<>();
		List<Average> averageLikes = new ArrayList<>();
		int avg = 0;
		int count = 0;
		Map<String, List> map = new HashMap<>();
		String ratings = "0";
		String highestTitle = "";
		
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject json = (JSONObject) jsonArray.get(i);
			JSONArray jsonArrays = (JSONArray) json.get("comments");
			String title = (String) json.get("title");
			String rate = (String) json.get("age_rating");
			if(Integer.parseInt(ratings) < Integer.parseInt(rate))
			{
				ratings = rate;
				highestTitle =title;
			}
			rating.add(rate);
			for (int j = 0; j < jsonArrays.size(); j++) {
				JSONObject job = (JSONObject) jsonArrays.get(j);
				avg += ((Long) job.get("like"));
				count++;
				users.add((String) job.get("user"));
			}
			
			avg /= count;
			averageLikes.add(new Average(title, avg));
			count = 0;
		}
		
		Set<String> uniqueNames = new HashSet<>(users);
		int max = 0;
		int curr = 0;
		String user = null;
		
		// find user with most comments
		
		for (String name : uniqueNames) {
			curr = Collections.frequency(users, name);

			if (max < curr) {
				max = curr;
				user = name;
			}
		}
		
		// Add user with most comments and the highest rated title and return it in the map
		
		List<String> list = new ArrayList<>();
		list.add(user);
		list.add(highestTitle);

		map.put("rating", rating);
		map.put("averageLikes", averageLikes);
		map.put("maxComment", list);


		return map;
	}

	public GameRepository() {
	}

	
//	public List<GameTitle> getTitles() {
//		return titles;
//	}
//
//	public void setTitles(List<GameTitle> titles) {
//		this.titles = titles;
//	}

}
