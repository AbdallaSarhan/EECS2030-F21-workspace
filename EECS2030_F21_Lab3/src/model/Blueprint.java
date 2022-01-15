package model;



public class Blueprint {

	private String infoOnFloors;
	private int numOfFloors;
	private int numOfCompletedFloors;
	private double percentageDone;
	private Floor[] floors;
	// private int nof; // number of floors on new floor

	public Blueprint(int numOfFloors) {
		this.numOfFloors = numOfFloors;
		this.numOfCompletedFloors = 0;
		this.percentageDone = 0.0; 
		this.floors = new Floor[this.numOfFloors];
		// this.nof = 0;
		
		this.infoOnFloors = String.format("%.1f percents of building blueprint completed (%d out of %d floors)",
								this.percentageDone, this.numOfCompletedFloors, this.numOfFloors);
	}
	
	
	public Blueprint(Blueprint other)  {
		this(other.numOfFloors);
		for(int i = 0; i < other.numOfCompletedFloors; i++) {
			Floor src = other.floors[i];
			try {
				Floor nf = new Floor(src);
				this.addFloorPlan(nf);
			}
			catch(InsufficientFloorSpaceException e){
				
			}
			
		}
	}


	public void addFloorPlan(Floor floorName) {
		this.floors[this.numOfCompletedFloors] = floorName;
		this.numOfCompletedFloors++;
		this.percentageDone = (double) this.numOfCompletedFloors / this.numOfFloors; 
		this.percentageDone = this.percentageDone * 100;
		this.infoOnFloors = String.format("%.1f percents of building blueprint completed (%d out of %d floors)", 
				this.percentageDone, this.numOfCompletedFloors, this.numOfFloors);
	}
	
	public Floor[] getFloors() {
		Floor[] floor = new Floor[this.numOfCompletedFloors];
	
		for(int i = 0; i < this.numOfCompletedFloors; i++) {
			
			floor[i] = this.floors[i];
	
			try {
				floor[i] = new Floor(floors[i]);
			}
			catch(InsufficientFloorSpaceException e){
				
			}
		
		}
		
		return floor;
	}
	
	
	
	public String toString() {
		
		
		return this.infoOnFloors;
	}
}
