package attributes_OMDB;

public class Runtime extends Metric {

	public int runtimeVal;

	public Runtime(int runTVal) {
		runtimeVal = runTVal;
    }
	
	public void setRuntime(int runTVal){
		runtimeVal = runTVal;
	}
	
	public int getRuntime(){
		return runtimeVal;
	}
}
