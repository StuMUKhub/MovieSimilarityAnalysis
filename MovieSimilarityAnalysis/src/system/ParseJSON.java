package system;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import attributes_OMDB.Actor;
import attributes_OMDB.Genre;
import attributes_OMDB.Metric;
import attributes_OMDB.Movie;
import attributes_OMDB.Popularity;
import attributes_OMDB.Release_Date;
import attributes_OMDB.Vote_Average;
import attributes_OMDB.Vote_Count;
import attributes_OMDB_unmeasurable.Adult;
import attributes_OMDB_unmeasurable.Backdrop_Path;
import attributes_OMDB_unmeasurable.Original_Language;
import attributes_OMDB_unmeasurable.Original_Title;
import attributes_OMDB_unmeasurable.Overview;
import attributes_OMDB_unmeasurable.Poster_Path;
import attributes_OMDB_unmeasurable.Video;

/**
 * 
 * Parsing of JSon Strings occurs in this class.
 * 
 * @author Stuart Maynard
 *
 */

public class ParseJSON {

	private int totalPages = 0;
	private int totalResults = 0;
	private int resultsLeft = 0;

	public void parseMovieByIDCall(String jsonObj) {

		JSONObject obj = new JSONObject(jsonObj);

		System.out.println(jsonObj);

		/* JSon variables */

		// "adult"
		boolean adult = obj.optBoolean("adult");
		System.out.println(adult);

		// "backdrop_path"
		String backdrop_path = obj.optString("backdrop_path");
		System.out.println(backdrop_path);

		// "belongs_to_collection"
		// "belongs_to_collection" - Array Elements
		int btc_id = 0;
		String btc_name = "";
		String btc_poster_path = "";
		String btc_backdrop_path = "";
		// "belongs_to_collection" - Extraction
		if (obj.optJSONObject("belongs_to_collection") != null) {
			btc_id = obj.optJSONObject("belongs_to_collection").optInt("id");
			btc_name = obj.optJSONObject("belongs_to_collection").optString("name");
			btc_poster_path = obj.optJSONObject("belongs_to_collection").optString("poster_path");
			btc_backdrop_path = obj.optJSONObject("belongs_to_collection").optString("backdrop_path");
			System.out.println(btc_id);
			System.out.println(btc_name);
			System.out.println(btc_poster_path);
			System.out.println(btc_backdrop_path);
		}

		// "budget"
		int budget = obj.optInt("budget");
		System.out.println(budget);

		// "genres"
		JSONArray genres = obj.optJSONArray("genres");
		// "genres" - Array Elements
		int genre_id = 0;
		String genre_name = "";
		// "genres" - Extraction
		if (genres != null) {
			for (int i = 0; i < genres.length(); i++) {
				genre_id = genres.optJSONObject(i).optInt("id");
				genre_name = genres.optJSONObject(i).optString("name");
				System.out.println(genre_id);
				System.out.println(genre_name);
			}
		}

		// "homepage"
		String homepage = obj.optString("homepage");
		System.out.println(homepage);

		// "id"
		int id = obj.optInt("id");
		System.out.println(id);

		// "imdb_id"
		String imdb_id = obj.optString("imdb_id");
		System.out.println(imdb_id);

		// "original_lanuage"
		String original_language = obj.optString("original_language");
		System.out.println(original_language);

		// "original_title"
		String original_title = obj.optString("original_title");
		System.out.println(original_title);

		// "overview"
		String overview = obj.optString("overview");
		System.out.println(overview);

		// "popularity"
		double popularity = obj.optDouble("popularity");
		System.out.println(popularity);

		// "poster_path"
		String poster_path = obj.optString("poster_path");
		System.out.println(poster_path);

		// "production_companies"
		JSONArray production_companies = obj.optJSONArray("production_companies");
		// "production_companies" - Array Elements
		String p_com_name = "";
		int p_com_id = 0;
		// "production_companies" - Extraction
		if (production_companies != null) {
			for (int i = 0; i < production_companies.length(); i++) {
				p_com_name = production_companies.optJSONObject(i).optString("name");
				p_com_id = production_companies.optJSONObject(i).optInt("id");
				System.out.println(p_com_name);
				System.out.println(p_com_id);
			}
		}

		// "production_countries"
		JSONArray production_countries = obj.optJSONArray("production_countries");
		// "production_countries" - Array Elements
		String p_cou_iso_3166_1 = "";
		String p_cou_name = "";
		// "production_countries" - Extraction
		if (production_countries != null) {
			for (int i = 0; i < production_countries.length(); i++) {
				p_cou_iso_3166_1 = production_countries.optJSONObject(i).optString("iso_3166_1");
				p_cou_name = production_countries.optJSONObject(i).optString("name");
				System.out.println(p_cou_iso_3166_1);
				System.out.println(p_cou_name);
			}
		}

		// "release_date"
		String release_date = obj.optString("release_date");
		System.out.println(release_date);

		// "revenue"
		int revenue = obj.optInt("revenue");
		System.out.println(revenue);

		// "runtime"
		int runtime = obj.optInt("runtime");
		System.out.println(runtime);

		// "spoken_lanuages"
		JSONArray spoken_languages = obj.optJSONArray("spoken_languages");
		// "spoken_lanuages" - Array Elements
		String sp_la_iso_639_1 = "";
		String sp_la_cou_name = "";
		// "spoken_lanuages" - Extraction
		if (spoken_languages != null) {
			for (int i = 0; i < spoken_languages.length(); i++) {
				sp_la_iso_639_1 = spoken_languages.optJSONObject(i).optString("iso_639_1");
				sp_la_cou_name = spoken_languages.optJSONObject(i).optString("name");
				System.out.println(sp_la_iso_639_1);
				System.out.println(sp_la_cou_name);
			}
		}

		// "status"
		String status = obj.optString("status");
		System.out.println(status);

		// "tagline"
		String tagline = obj.optString("tagline");
		System.out.println(tagline);

		// "title"
		String title = obj.optString("title");
		System.out.println(title);

		// "video"
		boolean video = obj.optBoolean("video");
		System.out.println(video);

		// "vote_average"
		double vote_average = obj.optDouble("vote_average");
		System.out.println(vote_average);

		// "vote_count"
		int vote_count = obj.optInt("vote_count");
		System.out.println(vote_count);
	}

	public JSONObject nextPage(String url_page, int page_count) {
		JSONObject next = new JSONObject();

		next = new JSONObject(new URL_Call().requestURL(url_page + "&page=" + page_count));

		return next;
	}

	public void parseDiscoverList(String discovered, String url) {

		JSONObject page = new JSONObject(discovered);
		totalPages = page.optInt("total_pages");
		totalResults = page.optInt("total_results");

		resultsLeft = totalResults;

		System.out.println("DISC: " + discovered);
		JSONArray list = page.optJSONArray("results");
		System.out.println("LIST: " + list);

		parseDiscoverPage(list);

		if (totalPages > 40) {
			for (int i = 2; i <= 40; i++) {
				page = nextPage(url, i);
				if (page != null) {
					list = page.optJSONArray("results");
					parseDiscoverPage(list);
				}
			}
		} else {
			for (int i = 2; i <= totalPages; i++) {
				page = nextPage(url, i);
				if (page != null) {
					list = page.optJSONArray("results");
					parseDiscoverPage(list);
				}
			}
		}
	}

	public ArrayList<ArrayList<Metric>> parseDiscoverPage(JSONArray discovered_page) {

		ArrayList<Metric> eachMovie = new ArrayList<Metric>();
		ArrayList<ArrayList<Metric>> allResults = new ArrayList<ArrayList<Metric>>();
		
		JSONArray obj = discovered_page;
		// System.out.println("DISC PAGE: " + discovered_page);

		if (resultsLeft > 20) {
			for (int i = 0; i <= 19; i++) {

				// "overview"
				String overview = obj.optJSONObject(i).optString("overview");
				Overview overviewToAdd = new Overview(overview);
				eachMovie.add(overviewToAdd);

				// "original_lanuage"
				String original_language = obj.optJSONObject(i).optString("original_language");
				Original_Language originalLanguageToAdd = new Original_Language(original_language);
				eachMovie.add(originalLanguageToAdd);

				// "original_title"
				String original_title = obj.optJSONObject(i).optString("original_title");
				Original_Title originalTitleToAdd = new Original_Title(original_title);
				eachMovie.add(originalTitleToAdd);


				// "video"
				boolean video = obj.optJSONObject(i).optBoolean("video");
				Video vidToAdd = new Video(video);
				eachMovie.add(vidToAdd);

				// "title"
				String title = obj.optJSONObject(i).optString("title");
				Movie movieToAdd = new Movie(title, 0, 0);

				// "genre IDs"
				JSONArray genre_ids = obj.optJSONObject(i).optJSONArray("genre_ids");
				// "genres" - Array Elements
				int genre_id = 0;
				// "genres" - Extraction
				if (genre_ids != null) {
					for (int j = 0; j < genre_ids.length(); j++) {
						genre_id = genre_ids.optInt(j);
						Genre genreToAdd = new Genre("", genre_id);
						eachMovie.add(genreToAdd);
//						System.out.println(genre_id);
						
					}
				}

				// "poster_path"
				String poster_path = obj.optJSONObject(i).optString("poster_path");
				Poster_Path pPathToAdd = new Poster_Path(poster_path);
				eachMovie.add(pPathToAdd);

				// "backdrop_path"
				String backdrop_path = obj.optJSONObject(i).optString("backdrop_path");
				Backdrop_Path bPathToAdd = new Backdrop_Path(backdrop_path);
				eachMovie.add(bPathToAdd);

				// "release_date"
				String release_date = obj.optJSONObject(i).optString("release_date");
				Release_Date rDateToAdd = new Release_Date(release_date);
				eachMovie.add(rDateToAdd);
				
				// "popularity"
				double popularity = obj.optJSONObject(i).optDouble("popularity");
				Popularity popToAdd = new Popularity(popularity);
				eachMovie.add(popToAdd);

				// "vote_average"
				double vote_average = obj.optJSONObject(i).optDouble("vote_average");
				Vote_Average vAverageToAdd = new Vote_Average(vote_average);
				eachMovie.add(vAverageToAdd);
				
				// "id"
				int id = obj.optJSONObject(i).optInt("id");
				movieToAdd.setMovieID(id);
				eachMovie.add(movieToAdd);

				// "adult"
				boolean adult = obj.optJSONObject(i).optBoolean("adult");
				Adult adultToAdd = new Adult(adult);
				eachMovie.add(adultToAdd);

				// "vote_count"
				int vote_count = obj.optJSONObject(i).optInt("vote_count");
				Vote_Count vCountToAdd = new Vote_Count(vote_count);
				eachMovie.add(vCountToAdd);

//				System.out.println(overview);
//				System.out.println(original_language);
//				System.out.println(original_title);
//				System.out.println(video);
//				System.out.println(poster_path);
//				System.out.println(title);
//				System.out.println(backdrop_path);
//				System.out.println(release_date);
//				System.out.println(popularity);
//				System.out.println(vote_average);
//				System.out.println(id);
//				System.out.println(adult);
//				System.out.println(vote_count);
				
				allResults.add(eachMovie);
				
				resultsLeft--;
			}

		} else {
			for (int i = 0; i < resultsLeft; i++) {

				// "overview"
				String overview = obj.optJSONObject(i).optString("overview");
				Overview overviewToAdd = new Overview(overview);
				eachMovie.add(overviewToAdd);

				// "original_lanuage"
				String original_language = obj.optJSONObject(i).optString("original_language");
				Original_Language originalLanguageToAdd = new Original_Language(original_language);
				eachMovie.add(originalLanguageToAdd);

				// "original_title"
				String original_title = obj.optJSONObject(i).optString("original_title");
				Original_Title originalTitleToAdd = new Original_Title(original_title);
				eachMovie.add(originalTitleToAdd);


				// "video"
				boolean video = obj.optJSONObject(i).optBoolean("video");
				Video vidToAdd = new Video(video);
				eachMovie.add(vidToAdd);

				// "title"
				String title = obj.optJSONObject(i).optString("title");
			
				// "genre IDs"
				JSONArray genre_ids = obj.optJSONObject(i).optJSONArray("genre_ids");
				// "genres" - Array Elements
				int genre_id = 0;
				// "genres" - Extraction
				if (genre_ids != null) {
					for (int j = 0; j < genre_ids.length(); j++) {
						genre_id = genre_ids.optInt(j);
//						System.out.println(genre_id);
						
					}
				}

				// "poster_path"
				String poster_path = obj.optJSONObject(i).optString("poster_path");
				Poster_Path pPathToAdd = new Poster_Path(poster_path);
				eachMovie.add(pPathToAdd);

				// "backdrop_path"
				String backdrop_path = obj.optJSONObject(i).optString("backdrop_path");
				Backdrop_Path bPathToAdd = new Backdrop_Path(backdrop_path);
				eachMovie.add(bPathToAdd);

				// "release_date"
				String release_date = obj.optJSONObject(i).optString("release_date");
				Release_Date rDateToAdd = new Release_Date(release_date);
				eachMovie.add(rDateToAdd);
				
				// "popularity"
				double popularity = obj.optJSONObject(i).optDouble("popularity");
				Popularity popToAdd = new Popularity(popularity);
				eachMovie.add(popToAdd);

				// "vote_average"
				double vote_average = obj.optJSONObject(i).optDouble("vote_average");
				Vote_Average vAverageToAdd = new Vote_Average(vote_average);
				eachMovie.add(vAverageToAdd);
				
				// "id"
				int id = obj.optJSONObject(i).optInt("id");
				Movie movieToAdd = new Movie(title, id, 0);
				eachMovie.add(movieToAdd);

				// "adult"
				boolean adult = obj.optJSONObject(i).optBoolean("adult");
				Adult adultToAdd = new Adult(adult);
				eachMovie.add(adultToAdd);

				// "vote_count"
				int vote_count = obj.optJSONObject(i).optInt("vote_count");
				Vote_Count vCountToAdd = new Vote_Count(vote_count);
				eachMovie.add(vCountToAdd);
				
//				System.out.println(overview);
//				System.out.println(original_language);
//				System.out.println(original_title);
//				System.out.println(video);
//				System.out.println(poster_path);
//				System.out.println(title);
//				System.out.println(backdrop_path);
//				System.out.println(release_date);
//				System.out.println(popularity);
//				System.out.println(vote_average);
//				System.out.println(id);
//				System.out.println(adult);
//				System.out.println(vote_count);
				
				allResults.add(eachMovie);
			}
		}
		return allResults;
	}
	
	public ArrayList<Genre> parseGenreList(String in){
		
		ArrayList<Genre> returnGenres = new ArrayList<Genre>();
		JSONObject obj = new JSONObject(in);
		
		// "genres"
		JSONArray genres = obj.optJSONArray("genres");
		// "genres" - Array Elements
		int genre_id = 0;
		String genre_name = "";
		
		// "genres" - Extraction
		if (genres != null) {
			for (int i = 0; i < genres.length(); i++) {
				genre_id = genres.optJSONObject(i).optInt("id");
				genre_name = genres.optJSONObject(i).optString("name");
				Genre toAdd = new Genre(genre_name, genre_id);
				returnGenres.add(toAdd);
				
/*				TEST
				________________________________________
*/				
//				System.out.println(toAdd.genreID);
//				System.out.println(toAdd.genreName);
//				System.out.println(genre_id);
//				System.out.println(genre_name);
			}
		}
		return returnGenres;
	}

	public ArrayList<Actor> getActorID(String actorIN) {
		
		ArrayList<Actor> returnActors = new ArrayList<Actor>();
		JSONObject obj = new JSONObject(actorIN);
		
		JSONArray actors = obj.optJSONArray("results");	
		
		int actor_id = 0;
		String actor_name = "";
		
		// "Actors" - Extraction
		if (actors != null) {
			for (int i = 0; i < actors.length(); i++) {
				actor_id = actors.optJSONObject(i).optInt("id");
				actor_name = actors.optJSONObject(i).optString("name");
				Actor toAdd = new Actor(actor_name, actor_id);
				returnActors.add(toAdd);
				
/*				TEST
				________________________________________
*/				
//				System.out.println(toAdd.actorID);
//				System.out.println(toAdd.actorName);
//				System.out.println(actor_id);
//				System.out.println(actor_name);
			}
		}
		return returnActors;
	}
}
