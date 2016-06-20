package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.conection.DataBase;
import br.com.joao.gym.model.Member;
import br.com.joao.gym.model.Series;
import br.com.joao.gym.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MenuInstructorController {

	@FXML
	private TextField cpfField;
	
	@FXML
	private Label fullNameLabel;
	
	@FXML
	private Label userNameLabel;
	
	User user;
	Member member;
	Series series = new Series();
	MainApp mainApp;
	
	@FXML
	private void initialize(){ 
	}

	@FXML
	private void handleAcessMember() throws Exception {
		if (isInputValid()) {
			
			//seta o cpf da tabela Member
			member.setCpf(cpfField.getText());
			
			//seta o cpf da tabela Series
			series.setMemberCpf(cpfField.getText());
			
			System.out.println(series.getMemberCpf());
			
			fullNameLabel.setText(member.getFullName());
		}
	}
	
	@FXML
	private void handleCreateNewSeries() throws Exception {
		mainApp.showCreateSeries();
	}

	private boolean isInputValid() {

		try {

			member = DataBase.getMember(cpfField.getText());

			if (cpfField.getText().equals(member.getCpf())) {
				System.out.println("Encontrou o cpf no banco");
				return true;
			}

			else {
				System.out.println("Não encontrou o cpf no banco");
				
				Alert alert2 = new Alert(AlertType.ERROR);

				alert2.setTitle("Invalid CPF");
				alert2.setHeaderText("This CPF is not registered");
				alert2.setContentText("Please correct the input");
				alert2.showAndWait();
				return false;
			}
		}

		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@FXML
	private void handleCurrentSeries() throws Exception {
		mainApp.showCurrentSeries(user);
	}

	public void setMenuInstructor(User user) {
		this.user = user;
		userNameLabel.setText(user.getUserName());
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
