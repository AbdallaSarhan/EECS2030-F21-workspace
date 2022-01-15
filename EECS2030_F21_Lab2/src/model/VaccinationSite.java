package model;

public class VaccinationSite {
	private String l;
	private Vaccine[] vaccineDoses;
	// private int[] doses;
	private int nod; // number of doses
	private Vaccine[] vaccineKinds;
	private int nok; // number of kind of doses
	private String[] recognizedVaccines = {"mRNA-1273", "BNT162b2", "Ad26.COV2.S", "AZD1222"};
	private int doseLimit;
	private String status;
	private HealthRecord[] appointments;
	private int noa; // number of appointments
	private int nextDose;
	// private int count;
	// private int noad;
	//private String information;
	
	
	
	
	public VaccinationSite(String location, int accumulatedDosesLimit){
		this.l = location;
		this.doseLimit = accumulatedDosesLimit;
		this.vaccineDoses = new Vaccine[accumulatedDosesLimit];
		//this.doses = new int[accumulatedDosesLimit];
		this.nod = 0;
		this.vaccineKinds = new Vaccine[recognizedVaccines.length];
		this.nok = 0;
		this.noa = 0;
		this.appointments = new HealthRecord[200];
		this.status = String.format("%s has %d available doses: <>", this.l, nod);
		this.nextDose = 0;
		
		
	}
	
	public void bookAppointment(HealthRecord healthRecord) throws InsufficientVaccineDosesException{
		if(getNumberOfAvailableDoses() > noa ) {
			this.appointments[noa] = healthRecord;
			noa++;
			 healthRecord.changeStatus(String.format("Last vaccination appointment for %s with %s succeeded", 
						healthRecord.getName(),this.l)); 
		//	healthRecord.getAppointmentStatus() = s;
		}
		else {
			healthRecord.changeStatus(String.format("Last vaccination appointment for %s with %s failed", 
					healthRecord.getName(),this.l)); 
			throw new InsufficientVaccineDosesException();
			
		}
		
	}
	
	
	public void addDistribution(Vaccine v, int numOfDosesAdded) throws TooMuchDistributionException, UnrecognizedVaccineCodeNameException {
		
		//else {
			boolean recognized = false;
			for(int i = 0; i < recognizedVaccines.length && !recognized; i++) {
				if(recognizedVaccines[i].equals(v.getNameOfVaccine())) {
					recognized = true;
				}
			}
		
			boolean found = false;
			if(nod > 0) {
				for(int i = 0; i < nod  && !found; i++) {
					if(vaccineDoses[i].getNameOfVaccine().equals(v.getNameOfVaccine())){
						found = true;
					}
				}
			}
			if(!found && recognized) {
				vaccineKinds[nok] = v;
				nok++;
				
			}
			else if(!recognized == true) {
				throw new UnrecognizedVaccineCodeNameException("Unexpected exception thrown");
					
		
			}
			int avaliableDoses = nod;
			for(int i = avaliableDoses; i < avaliableDoses + numOfDosesAdded; i++ ) {
				if((avaliableDoses + numOfDosesAdded) > this.doseLimit) {
					throw new TooMuchDistributionException("Unexpected exception thrown");
				}
				else {
					vaccineDoses[nod] = v;
					nod++;
				}
				
			}
			String info = "";
			for(int i = 0; i < nok; i++) {
				
				if(i < nok-1) {
			info += getNumberOfAvailableDoses(vaccineKinds[i].getNameOfVaccine()) + " doses of " + vaccineKinds[i].getManufacturer() + ", ";
		}
				else {
					info += getNumberOfAvailableDoses(vaccineKinds[i].getNameOfVaccine()) + " doses of " + vaccineKinds[i].getManufacturer();
				}
				
				}
			this.status = String.format("%s has %d available doses: <%s>", this.l, nod, info);
		//	this.information = info;
			}
	//}
	
	public int getNumberOfAvailableDoses() {
		
		return this.nod;
	}
	
	
	public int getNumberOfAvailableDoses(String vaccineCode) {
		int noad = 0;
		// boolean found = false;
	for(int i = 0; i< nod; i++) {
		if (vaccineCode.equals(vaccineDoses[i].getNameOfVaccine())) {
			noad++;
			
	}

	}
	return noad;
	}
	

	
	public String toString() {
		
		
		return this.status;
	}
	
	
	public void administer(String date) {
	
		for(int i = 0; i < this.noa; i++) {
			appointments[i].addRecord(vaccineDoses[nextDose], this.l, date);
			String vaccineNameAtIndexCount = vaccineDoses[nextDose].getNameOfVaccine();
			
			for(int j = nextDose; j < nod; j++) {
				vaccineDoses[j] = vaccineDoses[j+1];
				
			}
			
			nod--;
			
			if(getNumberOfAvailableDoses(vaccineNameAtIndexCount)> 0) {
			
				for(int n = 0; n < this.nod; n++) {
					if(vaccineNameAtIndexCount.equals(vaccineDoses[n].getNameOfVaccine())) {
						nextDose = n;
					
					}
				
				}
				
			}
			else {
				nextDose = 0;
			}
		}
		for(int i = 0; i < noa; i++) {
			appointments[i] = null;
			
			
		}
		noa = 0;
		
		
		
			String info = "";
			for(int k = 0; k < nok; k++) {
				
				if(k < nok-1) {
			info += getNumberOfAvailableDoses(vaccineKinds[k].getNameOfVaccine()) + " doses of " + vaccineKinds[k].getManufacturer() + ", ";
		}
				else {
					info += getNumberOfAvailableDoses(vaccineKinds[k].getNameOfVaccine()) + " doses of " + vaccineKinds[k].getManufacturer();
				}
				
				}
			this.status = String.format("%s has %d available doses: <%s>", this.l, nod, info);
	
	}
	
	
}
