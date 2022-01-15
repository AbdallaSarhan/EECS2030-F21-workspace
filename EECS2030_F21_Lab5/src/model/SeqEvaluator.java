package model;

public abstract class SeqEvaluator {
	protected int[] seq1;
	protected int[] seq2;
	protected SeqOperation[] operations;
	protected int noo; //num of operations
	protected int notcompatible;
	
	public SeqEvaluator(int maxOperations){
		this.operations = new SeqOperation[maxOperations];
		this.noo = 0;
		this.notcompatible = 0;
	}
	
	
	public abstract void addOperation(String operation, int[] seq1, int[] seq2) throws IllegalOperationException;

}
