package attributes_OMDB_unmeasurable;

import attributes_OMDB.Metric;

public class Adult extends Metric {

	public boolean adultBool;

	public Adult(boolean adVal) {
		adultBool = adVal;
    }
	
	public void setAdult(boolean adVal){
		adultBool = adVal;
	}
	
	public boolean getAdult(){
		return adultBool;
	}
}
