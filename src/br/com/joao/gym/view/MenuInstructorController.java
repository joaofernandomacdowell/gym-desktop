package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.model.Member;
import br.com.joao.gym.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MenuInstructorController {
	
	@FXML
	private Label userNameLabel;
	
	User user;
	Member member;
	MainApp mainApp;
	
	@FXML
	private void initialize(){ 
	}
	
	@FXML
	private void handleCreateNewSeries() throws Exception {
		mainApp.showCreateSeries(user);
	}
	
	@FXML
	private void handleViewExistingSeries() throws Exception {
		mainApp.showViewSeries(user);
	}
	
	@FXML
	private void handleRegisterWorkout() throws Exception {
		//mainApp.showRegisterWorkout(user);
	}

	public void setMenuInstructor(User user) {
		this.user = user;
		userNameLabel.setText(user.getUserName());
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
