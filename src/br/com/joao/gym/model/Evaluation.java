package br.com.joao.gym.model;

import java.sql.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Evaluation {

	private final StringProperty memberCpf;
	private final ObjectProperty<Date> date;
	private final StringProperty time;
	private final StringProperty instructorName;


	public Evaluation(){
		this(null, null, null, null);
	}

	public Evaluation(String memberCpf, Date date, String time, String instructorName){
		this.memberCpf = new SimpleStringProperty (memberCpf);
		this.date = new SimpleObjectProperty<Date> (date);
		this.time = new SimpleStringProperty (time);
		this.instructorName = new SimpleStringProperty(instructorName);
	}

	// memberCpf methods
	public String getMemberCpf() {
		return memberCpf.get();
	}

	public void setMemberCpf(String memberCpf) {
		this.memberCpf.set(memberCpf);
	}

	public StringProperty userNameProperty() {
		return memberCpf;
	}
	//end: memberCpf methods


	//date methods
	public Date getDate() {
		return date.get();
	}

	public void setDate(Date date) {
		this.date.set(date);
	}

	public ObjectProperty<Date> userPasswordProperty() {
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


