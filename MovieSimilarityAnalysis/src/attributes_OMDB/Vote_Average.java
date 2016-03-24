package attributes_OMDB;

public class Vote_Average extends Metric {
	
	private double voteAverage;

	public Vote_Average(double vAVG) {
		voteAverage = vAVG;
    }
	
	public void setVoteAverage(double vAVG){
		voteAverage = vAVG;
	}
	
	public double getVoteAverage(){
		return voteAverage;
	}	
}
