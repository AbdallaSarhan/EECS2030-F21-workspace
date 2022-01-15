package model;

public class Projection implements BinarySeqOperation {
	
	private int[] sequence1;
	private int[] sequence2;
	private int[] projectedSequence;
	private int count;
	private String intListForProjectedS = "";
	
	public Projection(int[] sequence1, int[] sequence2) {
		this.sequence1 = sequence1;
		this.sequence2 = sequence2;
		count = 0;
		this.projectedSequence = new int[sequence2.length];
		for(int i = 0; i < this.sequence2.length; i++) {
			for(int j = 0; j < this.sequence1.length; j++) {
				if(this.sequence2[i] == this.sequence1[j]) {
					projectedSequence[count] = this.sequence1[j];
					count++;
					break;
				}
			}
			
		}
		for(int i = 0; i < count; i++) {
			if(i < count - 1) {
			this.intListForProjectedS += this.projectedSequence[i] + ", ";
		
			//	intListForProjectedS += ", ";
			}
			else {
				this.intListForProjectedS += this.projectedSequence[i];
			}
		}
	}
	
	public String getProjectedSequence() {
		
		return this.intListForProjectedS;
	}
	
	
	public String toString() {
		String result = null;
		String intListForS1 = "";
		for(int i = 0; i < this.sequence1.length; i++) {
			intListForS1 += this.sequence1[i];
			if(i < this.sequence1.length-1) {
				intListForS1 += ", ";
			}
		}
		String intListForS2 = "";
		for(int i = 0; i < this.sequence2.length; i++) {
			intListForS2 += this.sequence2[i];
			if(i < this.sequence2.length-1) {
				intListForS2 += ", ";
			}
		}
		
		
		result = String.format("Projecting [%s] to [%s] results in: [%s]", intListForS1, intListForS2, this.intListForProjectedS);
		return result;
	}
}
