package attributes_OMDB;

public class Production_Company extends Metric {

	public String prodCompName;
	public int prodCompID;
	
    public Production_Company(String pcName, int pcID) {
    	prodCompName = pcName;
    	prodCompID = pcID;
    }
    
    public void setProductionCompany(String pcName){
		prodCompName = pcName;
	}
	
    public String getProductionCompany(){
		return prodCompName;
	}
	
    public void setProductionCompanyID(int pcID){
		prodCompID = pcID;
	}
	
    public int getProductionCompanyID(){
		return prodCompID;
	}

}
