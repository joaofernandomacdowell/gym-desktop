package br.com.joao.gym.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import java.sql.SQLException;
import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.conection.DataBase;
import br.com.joao.gym.model.Medical;
import br.com.joao.gym.model.Member;
import br.com.joao.gym.model.User;


public class MedicalCertificateController {

	//Medical Certificate Informations
	@FXML
	private TextField memberCpfField;
	@FXML
	private TextField medicNameField;
	@FXML
	private TextField crmField;
	@FXML
	private DatePicker dateStartPicker;
	@FXML
	private DatePicker dateEndPicker;
	
	//Member Info
	@FXML
	private Label nameLabel;
	@FXML
	private Label medicalCertificateStatusLabel;
	@FXML
	private Label memberNameLabel;
	@FXML
	private Label statusLabel;

	//Receptionist that is logged
	@FXML
	private Label userNameLabel;

	private Member member;
	private User user;
	private MainApp mainApp;

	@FXML
	private void initialize() {
		hideLabels();
	}

	//Access Member button clicked
	@FXML
	private void handleAccessMember() throws SQLException, Exception {
		if (FoundMember()) {
			showLabels();
			System.out.println(member.getCpf());
		}	
	}

	//Register button clicked
	@FXML
	private boolean handleRegister() {

		if (isInputValid()) {
			Alert alertSuccess = new Alert(AlertType.CONFIRMATION);

			try {
				DataBase.insertMedicalCertificate(member.getCpf(), medicNameField.getText(), 
						crmField.getText(), dateStartPicker, dateEndPicker);
				
				member.setMedicalCertificate(changeMedicalStatus(member.getMedicalCertificate()));
				statusLabel.setText("Ok");
				
				DataBase.updateMedicalStatus(member.getCpf(), true);
				
				alertSuccess.showAndWait();
				alertSuccess.setTitle("Medical Certificate Registred!");
				alertSuccess.setContentText("Medical Certificate registred successfully!");

				clearFields();
				
				System.out.println("DateBase up-to-date");
				return true;
			} 
			
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return false;
	}

	//Back button clicked
	@FXML
	private void handleBack() throws Exception {
		mainApp.showMenuReceptionist(user);
	}

	//LogOut button clicked
	@FXML
	private void handleLogOut() throws Exception{	
		mainApp.showLogin();
	}

	/**
	 * Valida a entrada do usuário nos campos de texto.
	 * 
	 * @return true se a entrada é válida
	 */
	
	private boolean FoundMember() {
		try {
			member = DataBase.getMember(memberCpfField.getText());

			if (memberCpfField.getText().equals(member.getCpf())) {	
				memberNameLabel.setText(member.getFullName());
				
				//medical.setMemberCpf(member.getCpf());
				
				if (member.getMedicalCertificate() == true) {
					statusLabel.setText("Ok");
				}
				
				else
					statusLabel.setText("Not Ok");
				
				return true;
			}

			else {
				Alert alert = new Alert(AlertType.ERROR);
				
				alert.setTitle("Invalid CPF");
				alert.setHeaderText("This CPF is not registred");
				alert.setContentText("Please correct the input");
				alert.showAndWait();

				return false;
			}
		}

		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	private boolean isInputValid() {

		String errorMessage = "";
		
		if (medicNameField.getText() == null || medicNameField.getText().length() == 0) {
			errorMessage += "Invalid Name!\n"; 
		}

		if (crmField.getText() == null || crmField.getText().length() == 0) {
			errorMessage += "Invalid CPF!\n"; 
		}

		if (dateStartPicker.getValue() == null) {
			errorMessage += "Empty Start date!\n"; 
		}
		
		if (dateEndPicker.getValue() == null) {
			errorMessage += "Empty End date!\n"; 
		}
		
		if (errorMessage.length() == 0) {
			return true;
		} 

		else if (errorMessage.length() != 0) {
			Alert alert2 = new Alert(AlertType.ERROR);

			alert2.setTitle("Invalid Fields");
			alert2.setHeaderText("Please, correct the invalid fields");
			alert2.setContentText(errorMessage);
			alert2.showAndWait();

			return false;
		}
		return false;
	}
	
	private boolean changeMedicalStatus(boolean medicalStatus) {
		if (medicalStatus == false){
			return true;
		}
		
		return false;
	}

	private void hideLabels() {
		nameLabel.setVisible(false);
		statusLabel.setVisible(false);
		memberNameLabel.setVisible(false);
		medicalCertificateStatusLabel.setVisible(false);
	}
	
	private void showLabels() {
		nameLabel.setVisible(true);
		statusLabel.setVisible(true);
		memberNameLabel.setVisible(true);
		medicalCertificateStatusLabel.setVisible(true);
	}
	
	private void clearFields() {
		medicNameField.clear();
		memberCpfField.clear();
		crmField.clear();
	}
	
	public void setMedical(Medical medical) throws Exception {
		medicNameField.setText(medical.getMedicName());
		memberCpfField.setText(medical.getMemberCpf());
		crmField.setText(medical.getCrm());
	}

	public void setMedicalCertificate(User user) {
		this.user = user;
		userNameLabel.setText(user.getUserName());
	}

	public void setMainApp (MainApp mainApp){
		this.mainApp = mainApp;
	}
}