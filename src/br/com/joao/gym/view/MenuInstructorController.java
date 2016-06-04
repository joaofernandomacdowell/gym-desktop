package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import javafx.fxml.FXML;

public class MenuInstructorController {

	MainApp mainApp;
	
	@FXML
	private void initialize(){ 
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
