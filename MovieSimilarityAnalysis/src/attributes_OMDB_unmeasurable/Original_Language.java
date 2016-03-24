package attributes_OMDB_unmeasurable;

import attributes_OMDB.Metric;

public class Original_Language extends Metric {

	public String originalLanguageName;
	
    public Original_Language(String olName) {
    	originalLanguageName = olName;
    }
    
    public void setOriginalLanguage(String olName){
    	originalLanguageName = olName;
	}
	
    public String getOriginalLanguage(){
		return originalLanguageName;
	}
}
