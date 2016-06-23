package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MenuReceptionistController {

	@FXML
	private Label userNameLabel;
	
	User user;
	private MainApp mainApp;
	
	
	@FXML
	private void initialize() {
	}
	
	@FXML
	private void handleRegisterNewMember() throws Exception {	
		mainApp.showRegisterMember(user);
	}
	
	@FXML
	private void handleVerifyPayment() throws Exception {
		mainApp.showVerifyPayment(user);
	}
	
	@FXML
	private void handleScheduleEvaluation() throws Exception {
		mainApp.showScheduleEvaluation(user);
	}
	
	@FXML
	private void handleMedicalCertificate() throws Exception {
		mainApp.showMedicalCertificate(user);
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setMenuReceptionist(User user) {
		this.user = user;
		userNameLabel.setText(user.getUserName());
	}
}

