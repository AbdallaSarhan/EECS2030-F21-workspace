package model;


public class Log {
	
	private String version;
	//private String[] logEntries; // an array of log entries 
	private String[] fixes;
	private int nof; // number of fixes
	private final int MAX_CAPACITY = 10;
	//private App app;
	
	
	
	public Log(String version) {
		
		this.version = version;
		this.fixes = new String[MAX_CAPACITY];
		this.nof = 0;
	
	}

	// fixes[0] = 


	public String getVersion() {
		
				
		return this.version;
		
	}



	public int getNumberOfFixes() {

		return nof;
	}
	

	
	public String getFixes() {
		String output = "";
		for(int i = 0; i < this.nof; i++) {
			//System.out.println(fixes[i])
			if(i < this.nof-1) {
				output =  output + fixes[i] + "," + " " ;
				//output = output;
			}
			else {
				output+= fixes[i];
			}
			

		}
		
		
		return "["+ output + "]";
	}
	


	public void addFix(String fix) {
		fixes[nof] = fix;
		nof++;
		
	
	}
	
	
	public String toString() {
		String s = "" ;
		s += "Version" + " " + this.version + " " + "contains" + " " + nof + " " + "fixes" +  " " +  this.getFixes();
	
	 return s;
	}
}
