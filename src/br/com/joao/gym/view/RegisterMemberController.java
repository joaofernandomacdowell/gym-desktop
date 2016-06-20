package br.com.joao.gym.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

import java.time.LocalDate;
import java.util.Calendar;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.conection.DataBase;
import br.com.joao.gym.model.Member;
import br.com.joao.gym.model.User;
import br.com.joao.gym.util.DateUtil;


public class RegisterMemberController {

	//Contact Informations
	@FXML
	private TextField fullNameField;
	@FXML
	private TextField cpfField;
	@FXML
	private TextField rgField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField addressField;
	@FXML
	private TextField postalCodeField;
	@FXML
	private TextField phoneField;
	@FXML
	private TextField emailField;

	//Personal Informations
	@FXML
	private ChoiceBox<String> genderBox; 
	@FXML
	private DatePicker dateBirthPicker;
	@FXML
	private TextField ageField;

	//Contract and Payment
	@FXML
	private ChoiceBox<String> contractBox; 
	@FXML
	private ChoiceBox<String> paymentTypeBox;
	@FXML
	private ChoiceBox<String> paydayBox;


	//Receptionist that is logged
	@FXML
	private Label userNameLabel1;
	@FXML
	private Label userNameLabel2;
	@FXML
	private Label userNameLabel3;

	public boolean paymentStatus = false;
	public String payDate;
	public LocalDate localDate;
	
	private User user;
	private MainApp mainApp;
	
	ObservableList<String> genderList = FXCollections.observableArrayList(
			"Male", "Female", "Undefined"
			);

	ObservableList<String> contractList = FXCollections.observableArrayList(
			"Smart", "Black"
			);

	ObservableList<String> paymentList = FXCollections.observableArrayList(
			"Credit Card", "Debit Card"
			);

	ObservableList<String> paydayList = FXCollections.observableArrayList(
			"10", "20"
			);

	//Inicializa a classe controlle. Este m�todo � chamado automaticamente
	// ap�s o arquivo fxml ter sido carregado.

	@FXML
	private void initialize() {
		genderBox.setItems(genderList);
		
		contractBox.setValue("Black");
		contractBox.setItems(contractList);

		paymentTypeBox.setValue("Debit Card");
		paymentTypeBox.setItems(paymentList);

		paydayBox.setValue("20");
		paydayBox.setItems(paydayList);
	}

	@FXML
	private void calculateAge() {
    	Calendar now = Calendar.getInstance();
    	int year = now.get(Calendar.YEAR);
    	int birthYear = dateBirthPicker.getValue().getYear();
    	int age = year - birthYear;
    	ageField.setText(Integer.toString(age));
    }


	public void setMember(Member member) throws Exception {
		fullNameField.setText(member.getFullName());
		cpfField.setText(member.getCpf());
		rgField.setText(member.getRg());
		cityField.setText(member.getCity());

		addressField.setText(member.getCity());
		postalCodeField.setText(member.getPostalCode());
		phoneField.setText(member.getPhone());
		emailField.setText(member.getEmail());
		
		genderBox.setValue(member.getGender());
		/*
		if (member.getDateBirth() != null) {
		    dateBirthField.setValue(member.getDateBirth());
		} 
		
		else {
		    dateBirthField.setValue(null);
		}
		*/
		ageField.setText(Integer.toString(member.getAge()));

		contractBox.setValue(member.getContract());
		paymentTypeBox.setValue(member.getPaymentType());
		paydayBox.setValue(member.getPayday());

	}

	//Register button clicked
	@FXML
	private void handleRegister() {
		
		if (isInputValid()) {
			Alert alertSuccess = new Alert(AlertType.CONFIRMATION);

			try {
				DataBase.insertMember(fullNameField.getText(), cpfField.getText(), 
						rgField.getText(), cityField.getText(), addressField.getText(), 
						postalCodeField.getText(), phoneField.getText(), emailField.getText(), 
						genderBox.getValue(), dateBirthPicker, Integer.parseInt(ageField.getText()), 
						false, contractBox.getValue(), paymentTypeBox.getValue(), paydayBox.getValue());
				
				//localDate = new LocalDate(, 0, 0);
				//String payDate = DateUtil.format(dateBirthField.getValue());
				
				//payDate = paydayBox.getValue()+"/"+(Integer.toString(localDate.getMonthValue()))+"/"+(Integer.toString(localDate.getYear()));
				System.out.println("payDate = " + payDate);
				
				alertSuccess.showAndWait();
				alertSuccess.setTitle("User Registred!");
				alertSuccess.setContentText("User Registred Successfully");
				
				
				
				//Limpa os Fields
				clearFields();
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			System.out.println("Entro na fun��o");
		}
	}

	//Chamado quando o usu�rio clica Back.
	@FXML
	private void handleBack() throws Exception {
		mainApp.showMenuReceptionist(user);
	}

	//Chamado quando o usu�rio clica em LogOut
	@FXML
	private void handleLogOut() throws Exception{	
		mainApp.showLogin();
	}

	/**
	 * Valida a entrada do usu�rio nos campos de texto.
	 * 
	 * @return true se a entrada � v�lida
	 */
	private boolean isInputValid() {

		String errorMessage = "";

		if (fullNameField.getText() == null || fullNameField.getText().length() == 0) {
			errorMessage += "Invalid Name!\n"; 
		}

		if (cpfField.getText() == null || cpfField.getText().length() == 0) {
			errorMessage += "Invalid CPF!\n"; 
		}

		if (rgField.getText() == null || rgField.getText().length() == 0) {
			errorMessage += "Invalid RG!\n"; 
		}

		if (cityField.getText() == null || cityField.getText().length() == 0) {
			errorMessage += "Invalid City!\n"; 
		}

		if (addressField.getText() == null || addressField.getText().length() == 0) {
			errorMessage += "Invalid Address!\n"; 
		}

		if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
			errorMessage += "Invalid postal code!\n"; 
		}

		if (phoneField.getText() == null || phoneField.getText().length() == 0) {
			errorMessage += "Invalid Phone!\n"; 
		}

		if (emailField.getText() == null || emailField.getText().length() == 0) {
			errorMessage += "Invalid email!\n"; 
		}

		//if (dateBirthField.getText() == null || dateBirthField.getText().length() == 0) {
		//	errorMessage += "Invalid birthday!\n"; 
		//}

		if (ageField.getText() == null || ageField.getText().length() == 0) {
			errorMessage += "Invalid age!\n"; 
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

	private void clearFields() {
		fullNameField.clear();
		cpfField.clear();
		rgField.clear();
		cityField.clear();
		addressField.clear();
		phoneField.clear();
		postalCodeField.clear();
		emailField.clear();
		//dateBirthField.clear();
		ageField.clear();
	}
	
	public void setRegisterMember(User user) {
		this.user = user;
		userNameLabel1.setText(user.getUserName());
		userNameLabel2.setText(user.getUserName());
		userNameLabel3.setText(user.getUserName());
	}
	
	public void setMainApp (MainApp mainApp){
		this.mainApp = mainApp;
	}
}