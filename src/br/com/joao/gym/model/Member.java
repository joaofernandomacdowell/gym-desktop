package br.com.joao.gym.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Member {

	private final StringProperty fullName;
	private final IntegerProperty cpf;
	private final IntegerProperty rg; 
	private final StringProperty city;
	private final StringProperty address;
	private final IntegerProperty postalCode;
	private final IntegerProperty phone;
	private final StringProperty email;
	private final StringProperty birthday;
	//private final ObjectProperty<LocalDate> birthday;
	private IntegerProperty age;
	private final StringProperty contract;
	private final StringProperty paymentType;
	
	
	public Member() { 
		 this(null, 0, 0, null, null, 0, 0, null, null, 0, null, null); 
	 }
	 

	public Member(String fullName, int cpf, int rg, String city, String address, 
			int postalCode, int phone, String email, String birthday, int age,
			String contract, String paymentType) {
		
		this.fullName = new SimpleStringProperty (fullName);
		this.cpf = new SimpleIntegerProperty (cpf);
		this.rg = new SimpleIntegerProperty (rg);
		this.city = new SimpleStringProperty (city);
		this.address = new SimpleStringProperty ("Rua Engenheiro Cesar Grilo");
		this.postalCode = new SimpleIntegerProperty (postalCode);
		this.phone = new SimpleIntegerProperty (phone);
		this.email = new SimpleStringProperty(email);
		this.birthday = new SimpleStringProperty(birthday);
		//this.birthday = new SimpleObjectProperty<LocalDate>(birthday);
		this.contract = new SimpleStringProperty(contract);
		this.paymentType = new SimpleStringProperty(paymentType);
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
	public int getCpf() {
		return cpf.get();
	}

	public void setCpf(int cpf) {
		this.cpf.set(cpf);
	}

	public IntegerProperty cpfProperty() {
		return cpf;
	}
	//end: cpf methods
	
	
	//rg methods
	public int getRg() {
		return rg.get();
	}

	public void setRg(int rg) {
		this.rg.set(rg);
	}

	public IntegerProperty rgProperty() {
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
	public int getPostalCode() {
		return postalCode.get();
	}

	public void setPostalCode(int postalCode) {
		this.postalCode.set(postalCode);
	}

	public IntegerProperty postalCodeProperty() {
		return postalCode;
	}
	//end: postalCode methods
	
	
	//phone methods
	public int getPhone() {
		return phone.get();
	}

	public void setPhone(int phone) {
		this.phone.set(phone);
	}

	public IntegerProperty phoneProperty() {
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
		return rg.get();
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
}