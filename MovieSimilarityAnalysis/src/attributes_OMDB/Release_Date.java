package attributes_OMDB;

public class Release_Date extends Metric {

	String releaseDate;
	
    public Release_Date(String rDate) {
    	releaseDate = rDate;
    }
    
    public void setReleaseDate(String rDate){
    	releaseDate = rDate;
	}
	
    public String getReleaseDate(){
		return releaseDate;
	}
}
