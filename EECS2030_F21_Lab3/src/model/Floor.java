package model;



public class Floor {
	private String status;
	private int avaliableSF;
	private int UsedSquareFeet; 
	private Unit[] units;
	private int nou; // number of units
	private final int MAX_UNITS = 20;
	private int remainingSpace;
	//	private Unit unit;
	//	private int count;
	// private String 


	public Floor(int avaliableSquareFeet) {
		this.avaliableSF = avaliableSquareFeet;
		this.remainingSpace = avaliableSquareFeet;
		this.UsedSquareFeet = 0;
		this.units = new Unit[MAX_UNITS];
		//	this.count = 0;
		this.status = String.format("Floor's utilized space is %d sq ft (%d sq ft remaining): []", 
				this.UsedSquareFeet, this.avaliableSF);


	}

	public Floor(Floor other) throws InsufficientFloorSpaceException {
		//this.units = new Unit[MAX_UNITS];
		this(other.avaliableSF);

		for(int i = 0; i < other.nou; i++) {
		Unit src = other.units[i];
			Unit nf = new Unit(src);
			
			this.addUnit(nf.getNameOfUnit(), nf.getWidth(),nf.getLength());
		}
	}

	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		else if(obj == null) {
			return false;
		}
		else if(this.getClass() != obj.getClass()) {
			return false;
		}

		Floor other = (Floor) obj;

		boolean result = false;
		

		if(this.nou == other.nou && this.avaliableSF == other.avaliableSF) {
	
			boolean allmatch = true;
			int indexOfSameUnit = 0;
			
			for(int j = 0; j < nou && allmatch; j++) {
				boolean match = false;
			for(int i = 0; i < nou; i++) {
				if(this.units[indexOfSameUnit].equals(other.units[i])) {
					match = true;
				}
				
				}
			if(match == false) {
				allmatch = false;
			}
				indexOfSameUnit++;
			}
			result = allmatch;

		}


		return result;


		// (this.units == other.units || this.units.length == other.units.length);

	}

	public void addUnit(String unitName, int width, int length) throws InsufficientFloorSpaceException {
		Unit unit = new Unit(unitName, width, length);

		if(width*length > this.remainingSpace) {
			throw new InsufficientFloorSpaceException("Not enough floor space");
		}
		else {
			units[nou] = unit;
			nou++;
			String infoOnUnits = "";
			int count = 0;
			int utilizedSF = 0;
			remainingSpace = this.avaliableSF;
			for(int i = count; i < nou; i++) {
				if(i < nou - 1) {

					infoOnUnits += units[i].getNameOfUnit() + ": " + units[i].getSquareFeet() + " sq ft " + "(" + units[i].getWidth() + "' by " + units[i].getLength() + "'), "; 
				}
				else {

					infoOnUnits += units[i].getNameOfUnit() + ": " + units[i].getSquareFeet() + " sq ft " + "(" + units[i].getWidth() + "' by " + units[i].getLength() + "')";

				}
				utilizedSF =  utilizedSF + units[i].getSquareFeet();
				
			}
			count++;
			this.remainingSpace = this.remainingSpace - utilizedSF;
			this.status = String.format("Floor's utilized space is %d sq ft (%d sq ft remaining): [%s]",
					utilizedSF, this.remainingSpace, infoOnUnits);
		}



	}




	public String toString() {


		return this.status;
	}




}
