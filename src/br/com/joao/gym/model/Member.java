package br.com.joao.gym.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Member {

	private final StringProperty fullName;
	private final IntegerProperty cpf;
	private final IntegerProperty rg; 
	private final StringProperty city;
	private final StringProperty adress;
	private final IntegerProperty postalCode;
	private final IntegerProperty phone;
	private final StringProperty email;
	private final ObjectProperty<LocalDate> birth;
	
	 /* private final StringProperty postalCode; private final StringProperty
	 * phone; private final ObjectProperty<LocalDate> birth; private final
	 * StringProperty email;
	 */

	
	 public Member() { 
		 this(null, 0, 0, null, null, 0, 0, null, null); 
	 }
	 

	public Member(String fullName, int cpf, int rg, String city, String adress, 
			int postalCode, int phone, String email, LocalDate birth) {
		
		this.fullName = new SimpleStringProperty (fullName);
		this.cpf = new SimpleIntegerProperty (cpf);
		this.rg = new SimpleIntegerProperty (rg);
		this.city = new SimpleStringProperty (city);
		this.adress = new SimpleStringProperty ("Rua Engenheiro Cesar Grilo");
		this.postalCode = new SimpleIntegerProperty (postalCode);
		this.phone = new SimpleIntegerProperty (phone);
		this.email = new SimpleStringProperty(email);
		this.birth = new SimpleObjectProperty<LocalDate> (LocalDate.of (1999, 2, 21));
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
	
			
	//adress methods
	public String getAdress() {
		return adress.get();
	} 

	public void setAdress(String adress) {
		this.adress.set(adress);
	}

	public StringProperty adressProperty() {
		return adress;
	}
	//end: adress methods
	
	
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
		
		
	//end: birth methods
}