package attributes_OMDB;

public class Popularity extends Metric{

	public double popularity;
	
    public Popularity(double popularityVal) {
    	popularity = popularityVal;
    }
    
    public void setPopularity(double pop){
    	popularity = pop;
	}
	
    public double getPopularity(){
		return popularity;
	}
}
