package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MenuAdminController {

	@FXML
	private Label userNameLabel;
	
	User user;
	MainApp mainApp;
	
	
	public void setMenuAdmin(User user) {
		this.user = user;
		userNameLabel.setText(user.getUserName());
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
