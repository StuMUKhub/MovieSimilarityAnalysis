package attributes_OMDB_unmeasurable;

import attributes_OMDB.Metric;

public class Poster_Path extends Metric {

	public String posterPath;

	public Poster_Path(String ppVal) {
		posterPath = ppVal;
    }
	
	public void setPosterPath(String ppVal){
		posterPath = ppVal;
	}
	
	public String getPosterPath(){
		return posterPath;
	}
}
