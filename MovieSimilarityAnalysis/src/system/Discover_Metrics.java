package system;

import java.util.ArrayList;

import attributes_OMDB.Actor;
import attributes_OMDB.Budget;
import attributes_OMDB.Genre;
import attributes_OMDB.Metric;

public class Discover_Metrics {

	String discoverStringURL = "https://api.themoviedb.org/3/discover/movie?api_key=64c44e78b515a793ad651ddfdf7ab4af";
	
	ArrayList<Genre> allGenres = new ArrayList<Genre>();
	ArrayList<Actor> searchActors = new ArrayList<Actor>();
	
	public static void main(String[] args) {
//		String received = "";
//		String url_Requested = "";
//		URL_Call c_url = new URL_Call();
//		ParseJSON parse = new ParseJSON();
//		
//		/*------------------------------------------*/
//		
//		received = c_url.requestURL(url_Requested);
//		System.out.println("\nJSON Output: \n" + received);
//			
//		/*------------------------------------------*/
//		
//		/* For METRIC parse */
//		"ArrayList" = parse.getActorID(received);
		
				/* Test for Metrics */			
//		ArrayList<String> met = new ArrayList<String>();
//		ArrayList<String> user = new ArrayList<String>();
//		
//		met.add("Actor/Actress");
//		user.add("Orlando Bloom");
//		
//		met.add("Genre");
//		user.add("Adventure");
//		
//		Discover_Metrics disc = new Discover_Metrics();
//		disc.discoverString(met, user);

	}
	
	public String discoverString(ArrayList<String> metrics, ArrayList<String> userIN){
		ArrayList<String> metricsToDiscover = metrics;
		ArrayList<String> userINtoDiscover = userIN;
		
		ArrayList<Metric> metricsFOUND = new ArrayList<Metric>();
		ArrayList<Actor> actorsFOUND = new ArrayList<Actor>();
		ArrayList<Genre> genresFOUND = new ArrayList<Genre>();
		
		for(int i = 0 ; i<metricsToDiscover.size(); i++){
			switch(metricsToDiscover.get(i)){
			case "Actor/Actress":
				String actorName = userINtoDiscover.get(i);
				String actorName_forURL = actorName.replaceAll("\\s+", "+");
				System.out.println(actorName_forURL);
				
				String url_Requested_Actors = "https://api.themoviedb.org/3/search/person?api_key=64c44e78b515a793ad651ddfdf7ab4af&search_type=ngram&query=" + actorName_forURL;
				URL_Call actor_Call = new URL_Call();
				ParseJSON actor_Parse = new ParseJSON();
				
				String actors_Received = actor_Call.requestURL(url_Requested_Actors);
				searchActors = actor_Parse.getActorID(actors_Received);
				
				actorsFOUND.add(searchActors.get(0));
//				actorsFOUND.addAll(searchActors);
					
//					System.out.println(((Actor) metricsFOUND.get(j)).getActorName());
//					System.out.println(((Actor) metricsFOUND.get(j)).getActorID());
//					System.out.println(searchActors.get(j).actorName);
//					System.out.println(searchActors.get(j).actorID);
				break;
			case "Budget":
				int budgetValue = Integer.parseInt(userINtoDiscover.get(i));
				Budget newBudget = new Budget(budgetValue);
				metricsFOUND.add(newBudget);
				
//				System.out.println(((Budget) metricsFOUND.get(i)).getBudget());
				break;
			case "Genre":
				String url_Requested_Genres = "https://api.themoviedb.org/3/genre/movie/list?api_key=64c44e78b515a793ad651ddfdf7ab4af";
				URL_Call genre_call = new URL_Call();
				ParseJSON genres_Parse = new ParseJSON();	
				
				String genres_received = genre_call.requestURL(url_Requested_Genres);
				allGenres = genres_Parse.parseGenreList(genres_received);
				
				Genre newGenre = new Genre("", 0);
				String genreName = userINtoDiscover.get(i);
				
//				System.out.println("\nJSON Output: \n" + genres_received);	
				for(int k = 0; k<allGenres.size(); k++){
					if (genreName.equals(allGenres.get(k).getGenre())) {
						newGenre.setGenre(allGenres.get(k).getGenre());
						newGenre.setGenreID(allGenres.get(k).getGenreID());
						genresFOUND.add(newGenre);
						break;
					}
				}
				break;
			case "Production Company":
			case "Production Country":
			case "Release Date":
			case "Revenue":
			case "Runtime":
			case "Spoken Language":
			case "Vote Average":
			case "Vote Count":
			}
		}		
		
//		ACTORS
		int actorCount = actorsFOUND.size();
		boolean actorSameMovie = true;
		
		if(actorCount == 1){
			discoverStringURL = discoverStringURL + "&with_cast=" + ((Actor) actorsFOUND.get(0)).getActorID();
		}else if(actorCount > 1 & actorSameMovie == true){
			discoverStringURL = discoverStringURL + "&with_cast=" + ((Actor) actorsFOUND.get(0)).getActorID();
			for(int j=1; j<actorCount; j++){
				discoverStringURL = discoverStringURL + "," + ((Actor) actorsFOUND.get(j)).getActorID();
			}
		}else if(actorCount > 1 && actorSameMovie == false){
			for(int j=0; j<actorCount; j++){
				discoverStringURL = discoverStringURL + "&with_cast=" + ((Actor) actorsFOUND.get(j)).getActorID();
			}
		}
		
//		GENRES
		int genreCount = genresFOUND.size();
		boolean genreSameMovie = true;
		
		if(genreCount == 1){
			discoverStringURL = discoverStringURL + "&with_genres=" + ((Genre) genresFOUND.get(0)).getGenreID();
		}else if(genreCount > 1 & genreSameMovie == true){
			discoverStringURL = discoverStringURL + "&with_genres=" + ((Genre) genresFOUND.get(0)).getGenreID();
			for(int j=1; j<genreCount; j++){
				discoverStringURL = discoverStringURL + "," + ((Genre) genresFOUND.get(j)).getGenreID();
			}
		}else if(genreCount > 1 && genreSameMovie == false){
			for(int j=0; j<actorCount; j++){
				discoverStringURL = discoverStringURL + "&with_genres=" + ((Genre) genresFOUND.get(j)).getGenreID();
			}
		}

//		discoverString = discoverString + ".desc";
		
		System.out.println("DM: " + discoverStringURL);
		
		String url_Requested = discoverStringURL;
		URL_Call c_url = new URL_Call();
		
		/*------------------------------------------*/
		
		String received = c_url.requestURL(url_Requested);
		System.out.println("\nJSON Output FINAL: \n" + received);
		
		return discoverStringURL;
	}
}
