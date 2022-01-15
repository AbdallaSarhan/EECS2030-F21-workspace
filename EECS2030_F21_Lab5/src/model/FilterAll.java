package model;

public class FilterAll extends SeqEvaluator {
	
	private String result;
	private OccursWithin[] occurs;
	private int noc; // num of checks
	private String booleanList ="";
	private int notCompatible;
	private boolean valid;
	
	public FilterAll(int maxOperations) {
		super(maxOperations);
		this.occurs = new OccursWithin[maxOperations];
		this.noc = 0;
	 this.notCompatible = 0;
	}
	
	public void addOperation(String operation, int[] seq1, int[] seq2) throws IllegalOperationException {
		
		valid = false;
		
		if(operation.equals("op:occursWithin")) {
			OccursWithin occurs = new OccursWithin(seq1, seq2);
			this.occurs[this.noc] = occurs;
			this.noc++;
			valid = true;
		}
		if(operation.equals("op:projection")) {
			this.notCompatible++;
			valid = true;
		}
		if(operation.equals("op:sumsOfPrefixes")) {
			this.notCompatible++;
			valid = true;
		}
		 if(valid == false) {
			throw new IllegalOperationException();
		}
		
	}
	
	
	public String toString() {
		for(int i = 0; i < this.noc; i ++) {
			if(this.occurs[i].getOccursorNot() == false) {
				this.booleanList += "_";
			}
			else {
				this.booleanList += this.occurs[i].getOccursorNot();
			}
			if(i < this.noc -1) {
			this.booleanList += ", ";
			}
		}
		if(this.notCompatible > 0) {
			result = String.format("Filter cannot be evaluated due to %d incompatile operations.", this.notCompatible);
		}
		else {
			result = String.format("Filter result is: %s", this.booleanList);
		}
		
		return result;
	}
}
