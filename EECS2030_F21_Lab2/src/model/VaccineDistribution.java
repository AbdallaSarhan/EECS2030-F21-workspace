package model;

public class VaccineDistribution {
	private String status;
	private Vaccine vaccine;
	private int nod;

	public VaccineDistribution(Vaccine vaccine, int numberOfDoses) {
		
		this.vaccine = vaccine;
		this.nod = numberOfDoses;
		
		this.status = String.format("%d doses of %s by %s", this.nod, this.vaccine.getNameOfVaccine(), this.vaccine.getManufacturer());
		
	}
	
	
	
	public String toString() {
		
		
		return this.status;
	}
}

