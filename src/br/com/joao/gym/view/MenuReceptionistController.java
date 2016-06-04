package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import javafx.fxml.FXML;

public class MenuReceptionistController {

	private MainApp mainApp;
	
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleRegisterNewMember() throws Exception {	
		mainApp.showRegisterMember();
	}
	
	@FXML
	private void handleVerifyPayment() throws Exception {
		mainApp.showVerifyPayment();
	}
	
	@FXML
	private void handleScheduleEvaluation() throws Exception {
		mainApp.showScheduleEvaluation();
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}

