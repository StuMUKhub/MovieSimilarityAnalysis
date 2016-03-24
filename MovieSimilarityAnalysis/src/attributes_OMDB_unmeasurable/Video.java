package attributes_OMDB_unmeasurable;

import attributes_OMDB.Metric;

public class Video extends Metric {

	public boolean vidBool;

	public Video(boolean vidVal) {
		vidBool = vidVal;
    }
	
	public void setVideo(boolean vidVal){
		vidBool = vidVal;
	}
	
	public boolean getVideo(){
		return vidBool;
	}
}
