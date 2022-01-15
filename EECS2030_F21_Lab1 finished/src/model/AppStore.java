package model;

public class AppStore {
	
	private String country;
	private int app;
	String[] stableApps;
	private int nosa;
	App[] apps;
	private final int MAX_CAPACITY = 50;

	

	public AppStore(String country, int availableApps) {
		this.country = country;
		this.app = availableApps;
		this.apps = new App[MAX_CAPACITY];
		this.nosa = 0; // number of stable apps
		this.stableApps = new String[nosa];
	}
	

	
	public String getBranch() {
		
		return this.country;
	}


	public App getApp(String appName) {
		App v = null;
		int index = -1;
		for(int i = 0; i < this.nosa; i++) {
			v = this.apps[i];
			if(v.getName().equals(appName)) {
				index = i;
				
			}
		
		}
		if(index < 0) {
			return null;
		}
		return this.apps[index];
		//return v;
	
		
	}


	public String[] getStableApps(int stableApps) {
		int count = 0;
		App[] stableApp = new App[this.nosa];      // create a new App array with number of stable apps
		for(int i = 0; i < this.nosa; i++) {
			
			stableApp[i] = this.getApp(getBranch());
			
//			if(this.stableApps == null) {
//			}
			
		}
		
		return this.stableApps;
		
	//	this.stableApps =  getStableApps(stableApps);
		
		
		
	}



	


	public void addApp(App app1) {
		apps[nosa] = app1;
		nosa++;
		
	}

}
