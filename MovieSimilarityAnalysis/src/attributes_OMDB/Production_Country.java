package attributes_OMDB;

public class Production_Country extends Metric {

	public String prodCounName;
	public int prodCoun_iso_3166_1;
	
    public Production_Country(String pcName, int pcIso) {
    	prodCounName = pcName;
    	prodCoun_iso_3166_1 = pcIso;
    }
    
    public void setProductionCountry(String pcName){
		prodCounName = pcName;
	}
	
    public String getProductionCountry(){
		return prodCounName;
	}
	
    public void setProductionCountryID(int pcIso){
		prodCoun_iso_3166_1 = pcIso;
	}
	
    public int getProductionCountryID(){
		return prodCoun_iso_3166_1;
	}
}
