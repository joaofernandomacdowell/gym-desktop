package br.com.joao.gym.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Member {

	private final StringProperty fullName;
	private final StringProperty cpf;
	private final StringProperty rg; 
	private final StringProperty city;
	private final StringProperty address;
	private final StringProperty postalCode;
	private final StringProperty phone;
	private final StringProperty email;
	private final StringProperty birthday;
	//private final ObjectProperty<LocalDate> birthday;
	private final IntegerProperty age;
	private final StringProperty contract;
	private final StringProperty paymentType;
	private final StringProperty payday;


	public Member() { 
		this(null, null, null, null, null, null, null, null, null, 0, null, null, null); 
	}


	public Member(String fullName, String cpf, String rg, String city, String address, 
			String postalCode, String phone, String email, String birthday, int age,
			String contract, String paymentType, String payday) {

		this.fullName = new SimpleStringProperty (fullName);
		this.cpf = new SimpleStringProperty (cpf);
		this.rg = new SimpleStringProperty (rg);
		this.city = new SimpleStringProperty (city);
		this.address = new SimpleStringProperty (address);
		this.postalCode = new SimpleStringProperty (postalCode);
		this.phone = new SimpleStringProperty (phone);
		this.email = new SimpleStringProperty(email);
		this.birthday = new SimpleStringProperty(birthday);
		this.age = new SimpleIntegerProperty(age);
		//this.birthday = new SimpleObjectProperty<LocalDate>(birthday);
		this.contract = new SimpleStringProperty(contract);
		this.paymentType = new SimpleStringProperty(paymentType);
		this.payday = new SimpleStringProperty(payday);
	}

	//fullName methods
	public String getFullName() {
		return fullName.get();
	} 

	public void setFullName(String fullName) {
		this.fullName.set(fullName);
	}

	public StringProperty fullNameProperty() {
		return fullName;
	}
	//end: fullName methods


	//cpf methods
	public String getCpf() {
		return cpf.get();
	}

	public void setCpf(String cpf) {
		this.cpf.set(cpf);
	}

	public StringProperty cpfProperty() {
		return cpf;
	}
	//end: cpf methods


	//rg methods
	public String getRg() {
		return rg.get();
	}

	public void setRg(String rg) {
		this.rg.set(rg);
	}

	public StringProperty rgProperty() {
		return rg;
	}
	//end: rg methods


	//city methods
	public String getCity() {
		return city.get();
	} 

	public void setCity(String city) {
		this.city.set(city);
	}

	public StringProperty cityProperty() {
		return city;
	}
	//end: city methods


	//address methods
	public String getAddress() {
		return address.get();
	} 

	public void setAddress(String address) {
		this.address.set(address);
	}

	public StringProperty addressProperty() {
		return address;
	}
	//end: address methods


	//postalCode methods
	public String getPostalCode() {
		return postalCode.get();
	}

	public void setPostalCode(String postalCode) {
		this.postalCode.set(postalCode);
	}

	public StringProperty postalCodeProperty() {
		return postalCode;
	}
	//end: postalCode methods


	//phone methods
	public String getPhone() {
		return phone.get();
	}

	public void setPhone(String phone) {
		this.phone.set(phone);
	}

	public StringProperty phoneProperty() {
		return phone;
	}
	//end: phone methods


	//email methods
	public String getEmail() {
		return email.get();
	} 

	public void setEmail(String email) {
		this.email.set(email);
	}

	public StringProperty emailProperty() {
		return email;
	}
	//end: email methods


	//birth methods
	public String getBirthday() {
		return birthday.get();
	} 

	public void setBirthday(String birthday) {
		this.birthday.set(birthday);
	}

	public StringProperty birthdayProperty() {
		return birthday;
	}	
	//end: birth methods


	//age methods
	public int getAge() {
		return age.get();
	}

	public void setAge(int age) {
		this.age.set(age);
	}

	public IntegerProperty ageProperty() {
		return age;
	}
	//end: age methods


	//contract methods
	public String getContract() {
		return contract.get();
	} 

	public void setContract(String contract) {
		this.contract.set(contract);
	}

	public StringProperty contractProperty() {
		return contract;
	}
	//end: contract methods


	//paymentType methods
	public String getPaymentType() {
		return paymentType.get();
	} 

	public void setPaymentType(String paymentType) {
		this.paymentType.set(paymentType);
	}

	public StringProperty paymentTypeProperty() {
		return paymentType;
	}
	//end: paymentType methods

	//payday methods
	public String getPayday() {
		return payday.get();
	} 

	public void setPayday(String paymentStatus) {
		this.payday.set(paymentStatus);
	}

	public StringProperty paydayProperty() {
		return payday;
	}
	//end: payday methods
}