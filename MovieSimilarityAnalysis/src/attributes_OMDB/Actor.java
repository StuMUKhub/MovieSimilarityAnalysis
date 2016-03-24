package attributes_OMDB;

public class Actor extends Metric {

	public String actorName;
	public int actorID;
	
    public Actor(String aName, int aID) {
    	actorName = aName;
    	actorID = aID;
    }
    
    public void setActorName(String aName){
    	actorName = aName;
	}
	
    public String getActorName(){
		return actorName;
	}
	
    public void setActorID(int aID){
    	actorID = aID;
	}
	
    public int getActorID(){
		return actorID;
	}
}
