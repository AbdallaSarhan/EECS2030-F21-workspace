package model;
import model.Log;

public class App {
	
	private String name; // name of app
	private Log log;
	private int[] ratings; // ratings of app
	// private String whatIsNew;
	//private String[] history;
	private Log[] version;
	private int rating;
	private int nou; // number of updates
	private int nor; // number of ratings
	private final int MAX_CAPACITY = 20;
	private final int MAX_CAPACITY2 = 10;
	
	
	public App(String name, int ratings) {
		
		this.name = name;
		this.ratings = new int[MAX_CAPACITY2];
		this.nou = 0;
		this.rating = 0;
		//this.history = new String[MAX_CAPACITY];
		this.version = new Log[MAX_CAPACITY];
		this.nor = 0;
	
	}
	
	
	
	public String getName() {
		
		return this.name;
	}
	

	public String getWhatIsNew() {
		
		if(this.log == null) {
			return "n/a";
		}
		else {
			return this.log.toString();
		}
	}
	

	public Log[] getUpdateHistory() {
		
		Log[] updateHistory = new Log[nou];      // create a new log with number of updates
		for(int i = 0; i < this.nou; i++) {
			
		
			updateHistory[i] = this.version[i];
			
	
		}
		
		return updateHistory;
	}
	
	
	public Log getVersionInfo(String versionInfo) {
		Log v = null;
		int index = -1;
		for(int i = 0; i < this.nou; i++) {
			v = this.version[i];
			if(v.getVersion().equals(versionInfo)) {
				index = i;
				
			}
		
		}
		if(index < 0) {
			return null;
		}
		return this.version[index];
		//return v;
	}
		
		
	//}
	public String getAverageRating() {
		double r = 0.0;
		if (nor == 0) 
		return "n/a";
		else {
			
			for (int i = 0; i < nor; i++) {
				r = r + this.ratings[i];
			}
			
			
		}
		double average = r/nor;
		
		return String.format("%.1f", average);
	}
	
	public int getNumOfRatings(int number){
		int n = 0;
		
		for(int i = 0; i < nor; i++)
			if(ratings[i] == number)
				n++;
			else {
				
			}
		return n;
	}

	public String getRatingReport() {
		
		if (nor == 0)
		return "No ratings submitted so far!";
		
		else {
			return "Average of" + " " + nor + " ratings: " + this.getAverageRating() + " (Score 5: " + this.getNumOfRatings(5) + 
					", Score 4: " + this.getNumOfRatings(4) + ", Score 3: " + this.getNumOfRatings(3) + ", Score 2: " + this.getNumOfRatings(2) +
					", Score 1: " + this.getNumOfRatings(1) + ")";
		}
		
	}


	public void releaseUpdate(String update) {
		
		this.log = new Log(update);
		//history[nou] = update;
		version[nou] = this.log;
		this.nou++;
		
		// Log v = new Log(update);
		
//		Entry ne = new Entry(sn, p);
//		this.entries[this.noe] = ne;
//		this.noe ++;
	}


	public void submitRating(int i) {
	//	this.rating = i;
		//nor++;
		this.ratings[nor] = i;
		nor++;
	}
	
	public String toString() {
		String s = "" ;
		
		s += name + " " + "(Current Version: "+ this.getWhatIsNew() + "; " + "Average Rating: " + this.getAverageRating() +")"; 
		
		return s;
	}

}
