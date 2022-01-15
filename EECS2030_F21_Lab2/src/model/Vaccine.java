package model;

public class Vaccine {
	private String vaccine;
	private String type;
	private String manufacturer;
	private String status;
	private String[] recognizedVaccines = {"mRNA-1273", "BNT162b2", "Ad26.COV2.S", "AZD1222"};
	
	
	public Vaccine(String vaccineCode, String type, String manufacturer) {
		this.vaccine = vaccineCode;
		this.type = type;
		this.manufacturer = manufacturer;
		
		
//		boolean found = false;
//		for(int i = 0; i < recognizedVaccines.length; i++) {
//			if(recognizedVaccines[i].equals(this.vaccine)){
//				found = true;
//		
//			}
//			
//			if(found == true) {
//				this.status = String.format("Recognized vaccine: %s (%s; %s)", this.vaccine, this.type, this.manufacturer);
//			}
//			else {
//				this.status = String.format("Unrecognized vaccine: %s (%s; %s)",
//					this.vaccine, this.type, this.manufacturer);
//		}
//		}

		// issue with while loop, not sure why.
//		boolean found = false;
//		int i = 0;
//		while(!found && i < recognizedVaccines.length-1) {
//			found = recognizedVaccines[i].equals(this.vaccine);
//			
//			i++;
//		}
//		if(found) {
//			this.status = String.format("Recognized vaccine: %s (%s; %s)", this.vaccine, this.type, this.manufacturer);
//		}
//		else {
//			this.status = String.format("Unrecognized vaccine: %s (%s; %s)",
//					this.vaccine, this.type, this.manufacturer);
//		}
		
	}
	
	

	public String getManufacturer() {
		return this.manufacturer;
	}
	public String getNameOfVaccine() {
		return this.vaccine;
	}
	
	public String getStatus() {
		boolean found = false;
		for(int i = 0; i < recognizedVaccines.length; i++) {
			if(recognizedVaccines[i].equals(this.vaccine)){
				found = true;
			//	this.status = String.format("Recognized vaccine: %s (%s; %s)", this.vaccine, this.type, this.manufacturer);
			}
			
			if(found == true) {
				this.status = String.format("Recognized vaccine: %s (%s; %s)", this.vaccine, this.type, this.manufacturer);
			}
			else {
				this.status = String.format("Unrecognized vaccine: %s (%s; %s)",
						this.vaccine, this.type, this.manufacturer);
			}
			}
		return this.status;
	}

	
	
	public String toString() {
		return this.getStatus();
	}

}
