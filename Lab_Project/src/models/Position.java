package models;

public class Position {
	
	private int positionID;
	private String name;
	
	public Position() {
		// TODO Auto-generated constructor stub
	}

	public Position(int positionID, String name) {
		super();
		this.positionID = positionID;
		this.name = name;
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
