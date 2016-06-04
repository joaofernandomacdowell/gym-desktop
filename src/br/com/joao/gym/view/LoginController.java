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
	private void initialize() { 
		
	}
	
	public void setLogin(User user) throws Exception {
        this.user = user;
        //user.userName = userNameField.getText();//loginField.setText(user.getUserName());
        //passwordField.setText(user.getUserPassword());
	}
	
	@FXML
    private void handleSubmit() throws Exception {
		
    	if (loginIsValid() == 0) {
    		mainApp.showMenuAdmin();
    	}
    	
    	else if (loginIsValid() == 1) {
    		mainApp.showMenuReceptionist();
    	}
    	
    	else if (loginIsValid() == 2) {
    		mainApp.showMenuInstructor();
    	}
    }
	
    public int loginIsValid () throws Exception {
    	String errorMessage = "";
    	
    	user = (DataBase.getUser(userNameField.getText()));
    	System.out.println("LoginController recebeu o usuer: " + user.getUserName());
    	
    	//System.out.println(user.getUserName());
    	//System.out.println(user.getUserPassword());
    	
    	if (user.getUserName().equals("root") && user.getUserPassword().equals("root")) {
    		System.out.println("If: User root");
    		return 0;
    	}
    	
    	else if (user.getUserName().equals("recep") && user.getUserPassword().equals("recep")) {
    		System.out.println("If: User receptionist");
    		return 1;
    	}
    	
    	else if (user.getUserName().equals("inst") && user.getUserPassword().equals("inst")) {
    		System.out.println("If: User instructor");
    		return 2;
    	}
    	
    	else {
	    	Alert alert = new Alert(AlertType.ERROR);
	    	
	    	alert.setTitle("User Invalido");
	        alert.setContentText(errorMessage);
	        alert.setHeaderText("Usuário Invalido");
	        alert.setContentText("Por favor, digite um usuário existente");
	        alert.showAndWait();
	        
	        return -1;
    	}
    	
    	/*
    	if (user.getUserName() == null || userNameField.getText().isEmpty() ||!userNameField.getText().contentEquals(user.getUserName())) {
    		
    		errorMessage += "Invalid user!\n";
    		Alert alert = new Alert(AlertType.ERROR);
    	
	    	alert.setTitle("User Invalido");
	        alert.setContentText(errorMessage);
	        alert.setHeaderText("Usuário Invalido");
	        alert.setContentText("Por favor, digite um usuário existente");
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
