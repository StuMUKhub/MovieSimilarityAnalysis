package attributes_OMDB;

public class Budget extends Metric {

	public int budgetVal;

	public Budget(int budVal) {
		budgetVal = budVal;
    }
	
	public void setBudget(int budVal){
		budgetVal = budVal;
	}
	
	public int getBudget(){
		return budgetVal;
	}
}
