package model;

public class ConcatAll extends SeqEvaluator {

	private String result;
	private String list = "";
	private String concat = "";
	private boolean valid;
	public ConcatAll(int maxOperations){
		super(maxOperations);
	}

	
	public void addOperation(String operation, int[] seq1, int[] seq2) throws IllegalOperationException{
		valid = false;
		if(operation.equals("op:projection")) {
			Projection projection = new Projection(seq1, seq2);
			this.operations[this.noo] = projection;
			this.noo++;
			valid = true;
		}
		
		if(operation.equals("op:sumsOfPrefixes")) {
			SumsOfPrefixes sum = new SumsOfPrefixes(seq1);
			this.operations[this.noo] = sum;
			this.noo++;
			valid = true;
		}
		
		if(operation.equals("op:occursWithin")) {
			this.notcompatible++;
			valid = true;
		}
		if(valid == false) {
			throw new IllegalOperationException();
		}
	}
	
	
	public String toString() {

		for(int i = 0; i < this.noo; i++) {
			if(this.operations[i] instanceof Projection) {
				list+= "["+ ((Projection)this.operations[i]).getProjectedSequence() + "]";
				if(i < this.noo - 1 && i != 0 && !(("["+ ((Projection)this.operations[i]).getProjectedSequence() + "]").equals("[]"))) {
					concat+= ", ";
				}
				concat+= ((Projection)this.operations[i]).getProjectedSequence();
				
				
			}
			if(this.operations[i] instanceof SumsOfPrefixes) {
				list+= "["+ ((SumsOfPrefixes)this.operations[i]).getSumList() + "]";
				if(i < this.noo - 1 && i != 0 && !(("["+ ((SumsOfPrefixes)this.operations[i]).getSumList() + "]").equals("[]"))) {
					concat+= ", ";
				}
				concat+= ((SumsOfPrefixes)this.operations[i]).getSumList();
			
				
			}
			
			if(i < this.noo - 1) {
				list += ", ";
			
			}
		
		}
		if(this.notcompatible > 0 ) {
			result = String.format("Concat cannot be evaluated due to %d incompatile operations.", this.notcompatible);
		}
		else {
			result = String.format("Concat(%s) = [%s]", this.list, this.concat);
		}
	

		return result;
	}
}
