package br.com.joao.gym.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
	
	private final StringProperty userName;
	private final StringProperty userPassword;
	private final StringProperty userGroup;
	
	public User(){
		this(null, null, null);
	}
	
	public User(String userName, String userPassword, String userGroup){
		this.userName = new SimpleStringProperty (userName);
		this.userPassword = new SimpleStringProperty (userPassword);
		this.userGroup = new SimpleStringProperty (userGroup);
	}
	
	// userName methods
	public String getUserName() {
		return userName.get();
	}
	
	public void setUserName(String userName) {
		this.userName.set(userName);
	}
	
	public StringProperty userNameProperty() {
		return userName;
	}
	//end: userName methods
	
	
	//password methods
	public String getUserPassword() {
		return userPassword.get();
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword.set(userPassword);
	}
	
	public StringProperty userPasswordProperty() {
		return userPassword;
	}
	//end: password methods
	

	//password methods
	public String getUserGroup() {
		return userGroup.get();
	}
		
	public void setUserGroup(String userGroup) {
		this.userGroup.set(userGroup);
	}
		
	public StringProperty userGroupProperty() {
		return userGroup;
	}
	//end: password methods
}


