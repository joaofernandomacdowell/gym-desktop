package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class ScheduleEvaluationController {

	//User Login informations
	@FXML
	private TextField cpfField;
	@FXML
	private TextField dateField;
	@FXML
	private TextField hourField;
	@FXML
	private TextField instructorField;
	@FXML
	private TextArea obsArea;
	
	private MainApp mainApp;

	@FXML
	private void initialize() { 
		
	}
	
	@FXML
	private void handleConfirm() {
		
	}
	
	@FXML
	private void handleBack() throws Exception {
		mainApp.showMenuReceptionist();
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
