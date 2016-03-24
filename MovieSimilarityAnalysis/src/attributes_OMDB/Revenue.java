package attributes_OMDB;

public class Revenue extends Metric {

	public int revenueVal;

	public Revenue(int revVal) {
		revenueVal = revVal;
    }
	
	public void setRevenue(int revVal){
		revenueVal = revVal;
	}
	
	public int getRevenue(){
		return revenueVal;
	}
}
