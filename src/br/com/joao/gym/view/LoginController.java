package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.conection.DataBase;
import br.com.joao.gym.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	
	User user;
	MainApp mainApp;
	
	//User Login informations
	@FXML
	private TextField userNameField;
	@FXML
	private PasswordField userPasswordField;
	
	@FXML
	private void initialize(){ 
	}
	
	public void setLogin(User user) throws Exception {
        this.user = user;
        //user.userName = userNameField.getText();//loginField.setText(user.getUserName());
        //passwordField.setText(user.getUserPassword());
        //userGroupBox.setItems(userGroupList); 
	}
	
	@FXML
    private void handleSubmit() throws Exception {
    	if(loginIsValid()){
    		System.out.println("User Correto");
    		
    		mainApp.showRegisterMember();	
    	}
    }
	
    public boolean loginIsValid () throws Exception {
    	String errorMessage = "";
    	
    	user = (DataBase.getUser(userNameField.getText()));
    	System.out.println("LoginController recebeu o usuer: " + user.getUserName());
    	
    	//System.out.println(user.getUserName());
    	//System.out.println(user.getUserPassword());
    	
    	if (user.getUserName().equals("root") && user.getUserPassword().equals("root")){
    		System.out.println("If: User root");
    		return true;
    	}
    	
    	else {
	    	Alert alert = new Alert(AlertType.ERROR);
	    	
	    	alert.setTitle("User Invalido");
	        alert.setContentText(errorMessage);
	        alert.setHeaderText("Usu�rio Invalido");
	        alert.setContentText("Por favor, digite um usu�rio existente");
	        alert.showAndWait();
	        
	        return false;
    	}
    	
    	/*
    	if (user.getUserName() == null || userNameField.getText().isEmpty() ||!userNameField.getText().contentEquals(user.getUserName())) {
    		
    		errorMessage += "Invalid user!\n";
    		Alert alert = new Alert(AlertType.ERROR);
    	
	    	alert.setTitle("User Invalido");
	        alert.setContentText(errorMessage);
	        alert.setHeaderText("Usu�rio Invalido");
	        alert.setContentText("Por favor, digite um usu�rio existente");
	        alert.showAndWait();
    	
	        return false;
    	}
    	
    	else if (errorMessage.length() == 0) {
    		return true;
    	}
    	
    	else {
    		return false;
    	}
    	*/
    }
	  
    
    public void setMainApp(MainApp mainApp) {

		this.mainApp = mainApp;
	}
}
