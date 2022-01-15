package model;

public class SumsOfPrefixes implements SeqOperation {
	
	
	private int[] seq;
	private String result;
	private int sum;
	private String array;
	private String sumList;
	public SumsOfPrefixes(int[] sequence) {
		this.seq = sequence;
		this.sum = 0; 
		this.array = "";
		this.sumList = "";
		this.sumList +=  this.sum;
		
		for(int i = 0; i < this.seq.length; i++) {
			this.array += this.seq[i];
			if(i < this.seq.length - 1){
			this.array += ", ";
		}
			
	}
		for(int j = 0; j < this.seq.length; j++) {
			 this.sum += this.seq[j];
//			 if(j < this.seq.length -1) {
//				 this.sumList += ", ";
//			 }
			 this.sumList += ", " + this.sum;
			 
			 
		}
	}
	
	public String getSumList() {
		return this.sumList;
	}
	
	public String toString() {
		this.result = String.format("Sums of prefixes of [%s] is: [%s]", this.array, this.sumList);
		
		return this.result;
	}

}
