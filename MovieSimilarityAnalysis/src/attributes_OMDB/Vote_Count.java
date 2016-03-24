package attributes_OMDB;

public class Vote_Count extends Metric {

	public int voteCount;

	public Vote_Count(int vcVal) {
		voteCount = vcVal;
    }
	
	public void setVoteCount(int vcVal){
		voteCount = vcVal;
	}
	
	public int getVoteCount(){
		return voteCount;
	}
}
