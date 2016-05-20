package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class LoginController {
	
	ObservableList<String> userGroupList = FXCollections.observableArrayList(
			"admin",
			"recepcionist",
			"instructor"
		);
	
	User user;
	private MainApp mainApp;
	
	//User Login informations
	@FXML
	private TextField userNameField;
	@FXML
	private TextField passwordField;
	@FXML
	private ChoiceBox<String> userGroupBox;
	
	
	@FXML
	private void initialize(){
		userGroupBox.setItems(userGroupList); 
	}
	
	public void setLogin(User user) throws Exception {
        this.user = user;
        //userNameField.setText(user.getUserName());
        //passwordField.setText(user.getUserPassword());
        //userGroupBox.setItems(userGroupList); 
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
