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
        //user.userName = userNameField.getText();
        //passwordField.setText(user.getUserPassword());
	}
	
	@FXML
    private void handleSubmit() throws Exception {
		int acc_type = loginIsValid();
		
    	if (acc_type == 0) {
    		mainApp.showMenuAdmin();
    	}
    	
    	else if (acc_type == 1) {
    		mainApp.showMenuReceptionist();
    	}
    	
    	else if (acc_type == 2) {
    		mainApp.showMenuInstructor();
    	}
    }
	
    public int loginIsValid () throws Exception {
    	Alert alert = new Alert(AlertType.ERROR);
    	user = (DataBase.getUser(userNameField.getText()));
    	
    	System.out.println("Usuário encontrado no banco: " + user.getUserName());
    	System.out.println("Senha encontrado no banco: " + user.getUserPassword());
    	System.out.println("Senha encontrado no banco: " + user.getUserPassword());
    	//System.out.println("conteudo do startswith: " + user.getUserName().startsWith("a"));
    	//System.out.println(user.getUserPassword());
    	
    	
    	if(userNameField.getText().isEmpty() || user.getUserName() == null 
    			|| !userNameField.getText().contentEquals(user.getUserName())){
        	alert.setTitle("User Error!");
        	alert.setHeaderText("Invalid User");
        	alert.setContentText("Invalid user, please insert a valid user.");
        	alert.showAndWait();
        
        	return 3; //3 means error 
    	}
    	
    	else if (user.getUserName().startsWith("a") && checkPassword()) {   		
    		System.out.println("If: User admin");
    		return 0;
    	}
    	
    	else if (user.getUserName().startsWith("r") && checkPassword()) {
    		System.out.println("If: User receptionist");
    		return 1;
    	}
    	
    	else if (user.getUserName().startsWith("i") && checkPassword()) {
    		System.out.println("If: User instructor");
    		return 2;
    	} 
    	
    	return 3; //for future purposes this method can't use else here                     
	}  
    
    public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
    
    public boolean checkPassword(){
    	Alert alert = new Alert(AlertType.ERROR);
    	
    	if(userPasswordField.getText().equals(user.getUserPassword())){
    		return true;
    	}
    	
    	else {
        	alert.setTitle("Password Error");
        	alert.setHeaderText("Incorrect Password");
        	alert.setContentText("Please insert the correct password.rmd");
        	alert.showAndWait();
    		
        	return false;
    	}
    }
}
