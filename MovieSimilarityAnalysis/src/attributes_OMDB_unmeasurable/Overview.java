package attributes_OMDB_unmeasurable;

import attributes_OMDB.Metric;

public class Overview extends Metric {

	public String overView;
	
    public Overview(String overviewVal) {
    	overView = overviewVal;
    }
    
    public void setOverview(String overviewVal){
    	overView = overviewVal;
	}
	
    public String getOverview(){
		return overView;
	}
}
