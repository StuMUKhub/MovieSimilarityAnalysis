package attributes_OMDB;

public class Movie extends Metric {

	public String movieName;
	public int movieID;
	public int movieIMDB_ID;
	
    public Movie(String mName, int mID, int mIMDB_ID) {
    	movieName = mName;
    	movieID = mID;
    	movieIMDB_ID = mIMDB_ID;
    }
    
    public void setMovie(String mName){
    	movieName = mName;
	}
	
    public String getMovie(){
		return movieName;
	}
	
    public void setMovieID(int mID){
		movieID = mID;
	}
	
    public int getMovieID(){
		return movieID;
	}
	
    public void setMovieIMDB_ID(int mIMDB_ID){
		movieIMDB_ID = mIMDB_ID;
	}
	
    public int getMovieIMDB_ID(){
		return movieIMDB_ID;
	}
}
