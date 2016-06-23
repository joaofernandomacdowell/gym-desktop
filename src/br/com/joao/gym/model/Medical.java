package br.com.joao.gym.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Medical {

	private final StringProperty memberCpf;
	private final StringProperty medicName;
	private final StringProperty crm;
	private final StringProperty dateStart;
	private final StringProperty dateEnd;

	public Medical(){
		this(null, null, null, null, null);
	}

	public Medical(String memberCpf, String medicName, String crm, String dateStart, String dateEnd){
		this.memberCpf = new SimpleStringProperty (memberCpf);
		this.medicName = new SimpleStringProperty(medicName);
		this.crm = new SimpleStringProperty(crm);
		this.dateStart = new SimpleStringProperty(dateStart);
		this.dateEnd = new SimpleStringProperty(dateEnd);
	}

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
	//end: memberCpf methods


	//password methods
	public String getCrm() {
		return crm.get();
	}

	public void setCrm(String crm) {
		this.crm.set(crm);
	}

	public StringProperty crmProperty() {
		return crm;
	}
	//end: password methods


	//medicName methods
	public String getMedicName() {
		return medicName.get();
	}

	public void setMedicName(String medicName) {
		this.medicName.set(medicName);
	}

	public StringProperty medicNameProperty() {
		return medicName;
	}
	//end: medicName methods
	

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


