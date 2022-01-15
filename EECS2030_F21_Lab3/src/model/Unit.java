package model;

public class Unit {
	private String nameOfRoom;
	private int widthOfRoom;
	private int lengthOfRoom;
	private int squareFeet;
	private String infoOnRoom;
	private boolean UnitInFeet = true;
	private double savedWidthInchValue;
	private double savedLengthInchValue;
	private double widthConversion;
	private double lengthConversion;
	
	
	public Unit(String roomName, int width, int length) {
		this.nameOfRoom = roomName;
		this.widthOfRoom = width;
		this.lengthOfRoom = length;
		this.infoOnRoom = "";
		this.infoOnRoom = String.format("A unit of %d square feet (%d' wide and %d' long) functioning as %s",
				getSquareFeet(), this.widthOfRoom, this.lengthOfRoom, this.nameOfRoom);
		widthConversion = this.widthOfRoom;
		 lengthConversion = this.lengthOfRoom;
		 
		
	}
	public Unit(Unit other) {
		this(other.nameOfRoom, other.widthOfRoom, other.lengthOfRoom);
		
	}
	
	
	public String getNameOfUnit() {
		return this.nameOfRoom;
	}
	public int getSquareFeet() {
		this.squareFeet = 0;
		this.squareFeet = this.widthOfRoom * this.lengthOfRoom;
		
		return this.squareFeet;
	}
	public int getWidth() {
		return this.widthOfRoom;
	}
	public int getLength() {
		return this.lengthOfRoom;
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
		Unit other = (Unit) obj;
		return this.squareFeet == other.squareFeet && this.nameOfRoom == other.nameOfRoom;
		
		
	}
	
	// 	- Use this conversion formula: One foot is equal to 0.3048 meter.
	 //	- Each value of meters and square meters should be displayed with 2 digits after the decimal point.
	
	public void toogleMeasurement() {
		if(UnitInFeet == true) {
			widthConversion = widthConversion * 0.3048;
			this.savedWidthInchValue = widthConversion;
			lengthConversion = lengthConversion * 0.3048;
			this.savedLengthInchValue = lengthConversion;
			double squareFeetConverted = lengthConversion * widthConversion;
			
			this.infoOnRoom = String.format("A unit of %.2f square meters (%.2f m wide and %.2f m long) functioning as Master Room", squareFeetConverted, widthConversion, lengthConversion);
			UnitInFeet = false;
		}
		else {
			
			widthConversion = this.savedWidthInchValue / 0.3048;
			int widthConverted = (int) Math.round(widthConversion);
			lengthConversion = this.savedLengthInchValue / 0.3048;
			int lengthConverted = (int) lengthConversion;
			int squareFeetConverted = lengthConverted * widthConverted;
			
			this.infoOnRoom = String.format("A unit of %d square feet (%d' wide and %d' long) functioning as Master Room", squareFeetConverted, widthConverted, lengthConverted);
			UnitInFeet = true;
			
		}
	
		
	}
	


	public String toString() {
		
		
		
		return infoOnRoom;
	}
}
