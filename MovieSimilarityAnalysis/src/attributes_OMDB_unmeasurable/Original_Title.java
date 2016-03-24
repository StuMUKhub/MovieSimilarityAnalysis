package attributes_OMDB_unmeasurable;

import attributes_OMDB.Metric;

public class Original_Title extends Metric {

	public String originalTitleName;
	
    public Original_Title(String otName) {
    	originalTitleName = otName;
    }
    
    public void setOriginalTitle(String otName){
    	originalTitleName = otName;
	}
	
    public String getOriginalTitle(){
		return originalTitleName;
	}
}
