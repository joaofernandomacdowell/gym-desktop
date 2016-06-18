package br.com.joao.gym.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Evaluation {

	private final IntegerProperty id;
	private final StringProperty memberCpf;
	private final StringProperty date;
	//private final ObjectProperty<Date> date;
	private final StringProperty time;
	private final StringProperty instructorName;


	public Evaluation(){
		this(0, null, null, null, null);
	}

	public Evaluation(int id, String memberCpf, String date, String time, String instructorName) {
		this.id = new SimpleIntegerProperty(id);
		this.memberCpf = new SimpleStringProperty (memberCpf);
		this.date = new SimpleStringProperty(date);
		this.time = new SimpleStringProperty (time);
		this.instructorName = new SimpleStringProperty(instructorName);
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

	
	// memberCpf methods
	public String getMemberCpf() {
		return memberCpf.get();
	}

	public void setMemberCpf(String memberCpf) {
		this.memberCpf.set(memberCpf);
	}

	public StringProperty memberCpfProperty() {
		return memberCpf;
	}
	//end: memberCpf methods


	//date methods
	public String getDate() {
		return date.get();
	}

	public void setDate(String date) {
		this.date.set(date);
	}

	public StringProperty dateProperty() {
		return date;
	}
	//end: date methods


	//time methods
	public String getTime() {
		return time.get();
	}

	public void setTime(String time) {
		this.time.set(time);
	}

	public StringProperty timeProperty() {
		return time;
	}
	//end: time methods


	//instructorName methods
	public String getInstructorName() {
		return instructorName.get();
	}

	public void setInstructorName(String instructorName) {
		this.instructorName.set(instructorName);
	}

	public StringProperty instructorNameProperty() {
		return instructorName;
	}
	//end: instructorName methods
}


