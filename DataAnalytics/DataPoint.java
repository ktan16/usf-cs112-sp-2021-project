package project2;

public class DataPoint {
	
	private Double f1;
	private Double f2;
	private String label;
	private Boolean isTest;
	
	/*
	 * Constructors
	 */
	
	public DataPoint() {
		this.f1 = null;
		this.f2 = null;
		this.label = null;
		this.isTest = null;
	}
	
	public DataPoint(Double f1, Double f2, String label, Boolean isTest) {
		this.setF1(f1);
		this.setF2(f2);
		this.setLabel(label);
		this.setIsTest(isTest);
	}
	
//	public DataPoint(Double f) {
//		this.setF1(f);
//		this.label = null;
//	}
//	
	
	/*
	 * Accessors
	 */
	
	public Double getF1() {
		return this.f1;
	}
	
	public Double getF2() {
		return this.f2;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public Boolean getIsTest() {
		return this.isTest;
	}
	
	/*
	 * Mutators
	 */
	
	public void setF1(Double f1) {
		this.f1 = f1;
	}
	
	public void setF2(Double f2) {

		this.f2 = f2;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public void setIsTest(Boolean isTest) {
		this.isTest = isTest;
	}
	
	public String toString() {
		return "f1: " + this.f1 + " f2: " + this.f2 + " label: " + this.label + " isTest: " + this.isTest;
	}
	

}
