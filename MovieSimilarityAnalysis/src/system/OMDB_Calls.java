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
		String url_Requested = "https://api.themoviedb.org/3/discover/movie?api_key=64c44e78b515a793ad651ddfdf7ab4af&with_cast=17276,3894,10297.desc";
		URL_Call c_url = new URL_Call();
		ParseJSON parse = new ParseJSON();
		
		/*------------------------------------------*/

		//Movie request by "id" e.g. 550
//		https://api.themoviedb.org/3/movie/76341?api_key=64c44e78b515a793ad651ddfdf7ab4af"
		
		/*Liam Neesons highest grossing R rated movies - 2 pages, 29 results*/ 
//		"https://api.themoviedb.org/3/discover/movie?api_key=64c44e78b515a793ad651ddfdf7ab4af&certification_country=US&certification=R&sort_by=revenue.desc&with_cast=3896"

		/*Search for a movies in theatres 77 pages, 1529 results*/
//		"https://api.themoviedb.org/3/discover/movie?api_key=64c44e78b515a793ad651ddfdf7ab4af&primary_release_date.gte=2016-01-01&primary_release_date.lte=2016-03-06"

		/*Highest rated movies rated R*/
//		"https://api.themoviedb.org/3/discover/movie?api_key=64c44e78b515a793ad651ddfdf7ab4af&certification_country=US&certification=R&sort_by=vote_average.desc"

		/*Most popular movies*/
//		"https://api.themoviedb.org/3/discover/movie?api_key=64c44e78b515a793ad651ddfdf7ab4af&sort_by=popularity.desc"
		
		/*------------------------------------------*/
		
		received = c_url.requestURL(url_Requested);
		System.out.println("\nJSON Output: \n" + received);
			
		/*------------------------------------------*/
		
		/* For single MOVIE return & parse */ 
//		parse.parseMovieByIDCall(received);
		
		/* For multiple MOVIE return & parse */
//		parse.parseDiscoverList(received, url_Requested);
		
		/* For GENRE parse */
//		parse.parseGenreList(received);
	}
}
