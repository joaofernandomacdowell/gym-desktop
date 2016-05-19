package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.model.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class LoginController {
	
	@FXML
	private TextField userNameField;
	@FXML
	private TextField passwordField;
	@FXML
	private ChoiceBox<String> userGroupBox;
	
	User user;
	
	private MainApp mainApp;
	
	@FXML
	private void initialize(){
	}
	
	public void setLogin(User user) throws Exception {
        this.user = user;
        userGroupBox = new ChoiceBox<String>();
        userGroupBox.setItems(FXCollections.observableArrayList("admin", "recepcionist", "instructor"));
	}
	
	  public void setMainApp(MainApp mainApp) {

		this.mainApp = mainApp;
	}
	
    
    @FXML
    private void handleSubmit() throws Exception {
    	//if(isLoginValid()){
    		System.out.println("User Correto");
    		
    		mainApp.showRegisterMember();	
    }
}
