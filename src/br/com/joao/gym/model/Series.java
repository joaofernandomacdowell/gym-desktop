package br.com.joao.gym.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Series {

	private final IntegerProperty id;
	private final StringProperty memberCpf;
	private final BooleanProperty workoutA; //workout A
	private final BooleanProperty workoutB; //workout B
	private final BooleanProperty workoutC; //workout C
	private final StringProperty dateStart;
	private final StringProperty dateEnd;


	public Series() { 
		this(0, null, false, false, false, null, null); 
	}


	public Series(int id, String memberCpf, boolean workoutA, boolean workoutB, boolean workoutC, String dateStart, String dateEnd) {
		this.id = new SimpleIntegerProperty(id);
		this.memberCpf = new SimpleStringProperty(memberCpf);
		this.workoutA = new SimpleBooleanProperty(workoutA);
		this.workoutB = new SimpleBooleanProperty(workoutB);
		this.workoutC = new SimpleBooleanProperty(workoutC);
		this.dateStart = new SimpleStringProperty(dateStart);
		this.dateEnd = new SimpleStringProperty(dateEnd);
	}

	//id methods
	public int getId() {
		return id.get();
	} 

	public void setId(int id) {
		this.id.set(id);
	}

	public IntegerProperty idProperty() {
		return id;
	}
	//end: id methods


	//memberCpf methods
	public String getMemberCpf() {
		return memberCpf.get();
	}

	public void setMemberCpf(String memberCpf) {
		this.memberCpf.set(memberCpf);
	}

	public StringProperty memberCpfProperty() {
		return memberCpf;
	}
	//end: memberCPF methods


	//workout A methods
	public boolean getWorkoutA() {
		return workoutA.get();
	} 

	public void setWorkoutA(boolean workoutA) {
		this.workoutA.set(workoutA);
	}

	public BooleanProperty workoutAStringProperty() {
		return workoutA;
	}	
	//end: workout A methods


	//workoutB methods
	public boolean getWorkoutB() {
		return workoutB.get();
	} 

	public void setWorkoutB(boolean workoutB) {
		this.workoutB.set(workoutB);
	}

	public BooleanProperty workoutBStringProperty() {
		return workoutB;
	}	
	//end: workoutB methods


	//workoutC methods
	public boolean getWorkoutC() {
		return workoutC.get();
	} 

	public void setWorkoutC(boolean workoutC) {
		this.workoutC.set(workoutC);
	}

	public BooleanProperty workoutCStringProperty() {
		return workoutC;
	}	
	//end: workoutC methods


	//dateStart methods
	public String getDateStart() {
		return dateStart.get();
	} 

	public void setDateStart(String dateStart) {
		this.dateStart.set(dateStart);
	}

	public StringProperty datesStartProperty() {
		return dateStart;
	}	
	//end: dateStart methods


	//dateEnd methods
	public String getDateEnd() {
		return dateEnd.get();
	} 

	public void setDateEnd(String dateEnd) {
		this.dateEnd.set(dateEnd);
	}

	public StringProperty datesEndProperty() {
		return dateEnd;
	}	
	//end: dateEnd methods
}
