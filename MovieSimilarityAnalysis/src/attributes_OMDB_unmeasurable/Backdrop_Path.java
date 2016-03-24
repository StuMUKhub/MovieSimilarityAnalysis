package attributes_OMDB_unmeasurable;

import attributes_OMDB.Metric;

public class Backdrop_Path extends Metric {
	
	public String backdropPath;

	public Backdrop_Path(String bpVal) {
		backdropPath = bpVal;
    }
	
	public void setBackdropPath(String bpVal){
		backdropPath = bpVal;
	}
	
	public String getBackdropPath(){
		return backdropPath;
	}
}
