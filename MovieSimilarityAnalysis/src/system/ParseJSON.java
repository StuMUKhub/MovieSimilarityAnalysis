package system;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 * Parsing of JSon Strings occurs in this class. 
 * 
 * @author Stuart Maynard
 *
 */

public class ParseJSON {

	public void parseMovieByIDCall(String jsonObj) {

		JSONObject obj = new JSONObject(jsonObj);

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
}
