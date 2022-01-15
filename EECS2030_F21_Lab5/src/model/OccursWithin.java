package model;

public class OccursWithin implements BinarySeqOperation {
	private String result;
	private int[] seq1;
	private int[] seq2;
	private boolean occurs;
	private int count;
	private int hold = 0;
	
	public OccursWithin(int[] sequence1, int[] sequence2) {
		this.seq1 = sequence1;
		this.seq2 = sequence2;
		this.occurs = false;
		this.count = 0;
		for(int j = 0; j < this.seq1.length; j++) {
			// loop through the first sequence 
			for(int i = hold; i < this.seq2.length; i++) {
				if(this.seq1[j] == this.seq2[i]) {
					count++;
					hold = i+1;
					if(this.count == this.seq1.length) {
						this.occurs = true;
						
					}
					break;
				}
				
			else {
				count = 0;
				
			}
		}
			
		}
	}
	public boolean getOccursorNot() {
		return this.occurs;
	}
	
	public String toString() {
		
		
		String intListForS1 = "";
		for(int i = 0; i < this.seq1.length; i++) {
			intListForS1 += this.seq1[i];
			if(i < this.seq1.length-1) {
				intListForS1 += ", ";
			}
		}
		String intListForS2 = "";
		for(int i = 0; i < this.seq2.length; i++) {
			intListForS2 += this.seq2[i];
			if(i < this.seq2.length-1) {
				intListForS2 += ", ";
			}
			
		
		}
		if(occurs == true) {
			result = String.format("[%s] occurs within [%s]", intListForS1,
					intListForS2);
		}
	else if(occurs == false) {
			result = String.format("[%s] does not occur within [%s]", intListForS1, intListForS2);
		}
		
		return result;
	
	
}
}