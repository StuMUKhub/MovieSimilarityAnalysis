package system;

/**
 * 
 * By using the API Key: 64c44e78b515a793ad651ddfdf7ab4af data can be pulled from The Online
 * Movie Database via a JSon String where it can be parsed correctly and compared to the data
 * parsed from the text files from GroupLens or by other JSon Strings pulled from OMDB
 * 
 * @author Stuart Maynard
 *
 */

public class OMDB_Calls {

	public static void main(String[] args) {
		String received = "";
		URL_Call c_url = new URL_Call();
		ParseJSON parse = new ParseJSON();

		//Movie request by "id" e.g. 550
		received = c_url.requestURL("https://api.themoviedb.org/3/movie/550?api_key=64c44e78b515a793ad651ddfdf7ab4af");
		
		/*Search for a movie based on test query*/
//		received = c_url.requestURL("https://api.themoviedb.org/3/search/movie?api_key=64c44e78b515a793ad651ddfdf7ab4af&james.search");
		
		/*Highest rated movies rated R*/
//		received = c_url.requestURL("https://api.themoviedb.org/3/discover/movie?api_key=64c44e78b515a793ad651ddfdf7ab4af&certification_country=US&certification=R&sort_by=vote_average.desc");

		/*Most popular movies*/
//		received = c_url.requestURL("https://api.themoviedb.org/3/discover/movie?api_key=64c44e78b515a793ad651ddfdf7ab4af&sort_by=popularity.desc");

		parse.parseMovieByIDCall(received);
		System.out.println("\nJSON Output: \n" + received);
	}
}
