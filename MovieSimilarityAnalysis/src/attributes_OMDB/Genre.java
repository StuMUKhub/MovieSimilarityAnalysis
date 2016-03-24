package attributes_OMDB;

public class Genre extends Metric{
	
	public String genreName;
	public int genreID;
	
    public Genre(String gName, int gID) {
    	genreName = gName;
    	genreID = gID;
    }
    
	public void setGenre(String gName){
		genreName = gName;
	}
	
	public String getGenre(){
		return genreName;
	}
	
	public void setGenreID(int gID){
		genreID = gID;
	}
	
	public int getGenreID(){
		return genreID;
	}
}
