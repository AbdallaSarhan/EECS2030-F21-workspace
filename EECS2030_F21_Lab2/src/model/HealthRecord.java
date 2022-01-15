package model;

public class HealthRecord {
	private String name;
	private Vaccine v;
	private String[] locationOfFacility;
	private String[] dateTaken;
	private Vaccine[] vaccines;
	private int nor;
	private VaccinationSite vs;
	private String status;
	private String s = "";
	
	
	public HealthRecord(String patientName, int doseLimit) {
		this.name = patientName;
		this.nor = 0;
		this.dateTaken = new String[doseLimit];	
		this.locationOfFacility = new String[doseLimit];
		this.vaccines = new Vaccine[doseLimit];
		this.status = String.format("No vaccination appointment for %s yet", this.name);
	}
	public String getName() {
		return this.name;
	}
	public void changeStatus(String status){
		this.status = status;
	}

	public void addRecord(Vaccine v, String location, String date) {
		this.locationOfFacility[nor] = location;
		this.dateTaken[nor] = date;
		this.vaccines[nor] = v;
		nor++;
		
		
	}
//		public void updateRecord(int vaccineRecord){
//		nor = vaccineRecord;
//	}
	
	public String getVaccinationReceipt() {
		String info = "";
		
		if(this.nor == 0) {
			 s = String.format("%s has not yet received any doses.", this.name);
		}
		else {
		for(int i = 0; i < nor; i++) {
			if(i < nor-1) {
				info += vaccines[i] + " in " + locationOfFacility[i] + " on " + dateTaken[i] + "; ";
			}
			else {
				info += vaccines[i] + " in " + locationOfFacility[i] + " on " + dateTaken[i];
			}
		}
		s = String.format("Number of doses %s has received: %d [%s]",
				this.name, this.nor, info);
		}
		return s;
	}
	
	public String getAppointmentStatus() {
		
		
		
				return this.status;
	}
}
