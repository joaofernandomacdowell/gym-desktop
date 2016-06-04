package br.com.joao.gym.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.conection.DataBase;
import br.com.joao.gym.model.Member;


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
	//INSERIR GÊNERO: MASCULINO/FEMININO
	@FXML
	private TextField birthdayField;
	//@FXML
	//private DatePicker birthdayField;
	@FXML
	private TextField ageField;


	//Contract and Payment

	@FXML
	private ComboBox<String> contractBox; 
	@FXML
	private ComboBox<String> paymentTypeBox;


	//Receptionist that is logged

	@FXML
	private Label userNameLabel1;
	@FXML
	private Tab userNameLabel2;
	@FXML
	private Tab userNameLabel3;

	private Member member;
	public boolean paymentStatus = false;
	private MainApp mainApp;

	ObservableList<String> contractList = FXCollections.observableArrayList(
			"Smart", "Black"
			);

	ObservableList<String> paymentList = FXCollections.observableArrayList(
			"Credit Card", "Debit Card"
			);

	//Inicializa a classe controlle. Este método é chamado automaticamente
	// após o arquivo fxml ter sido carregado.

	@FXML
	private void initialize() {
		contractBox.setValue("Black");
		contractBox.setItems(contractList);
		
		paymentTypeBox.setValue("Debit Card");
		paymentTypeBox.setItems(paymentList);
	
		//calculateAge();
	}

	/*private void calculateAge() {
    	Calendar now = Calendar.getInstance();
    	int year = now.get(Calendar.YEAR);
    	int birthYear = birthday.getValue().getYear();
    	int age = year - birthYear;
    	ageField.setText(Integer.toString(age));
    }*/


	public void setMember(Member member) throws Exception {

		this.member = member;

		fullNameField.setText(member.getFullName());
		cpfField.setText(member.getCpf());
		rgField.setText(member.getRg());
		cityField.setText(member.getCity());

		addressField.setText(member.getCity());
		postalCodeField.setText(member.getPostalCode());
		phoneField.setText(member.getPhone());
		emailField.setText(member.getEmail());

		birthdayField.setText(member.getBirthday());
		//birthdayField.setPromptText("dd.mm.yyyy");
		ageField.setText(Integer.toString(member.getAge()));
		
		contractBox.setValue(member.getContract());
		paymentTypeBox.setValue(member.getPaymentType());

	}

	/**
	 * Retorna true se o usuário clicar OK,caso contrário false.
	 * 
	 * @return
	 */

	//Chamado quando User clica no botão Register
	@FXML
	private void handleRegister() {
		if (isInputValid()) {
			member.setFullName(fullNameField.getText());
			member.setCpf(cpfField.getText());
			member.setRg(rgField.getText());
			member.setCity(cityField.getText());
			member.setAddress(addressField.getText());
			member.setPostalCode(postalCodeField.getText());
			member.setPhone(phoneField.getText());
			member.setEmail(emailField.getText());
			
			member.setBirthday(birthdayField.getText());
			member.setAge(Integer.parseInt(ageField.getText()));
			
			member.setContract(contractBox.getValue());
			member.setPaymentType(paymentTypeBox.getValue());
			
			//entra nova scene

		}
		
		else {
			System.out.println("Entro na função");
		}
	}

	//Chamado quando o usuário clica Back.
	@FXML
	private void handleBack() throws Exception {
		mainApp.showMenuReceptionist();
	}

	//Chamado quando o usuário clica em LogOut
	@FXML
	private void handleLogOut() throws Exception{	
		mainApp.showLogin();
	}

	/**
	 * Valida a entrada do usuário nos campos de texto.
	 * 
	 * @return true se a entrada é válida
	 */
	private boolean isInputValid() {
		
		String errorMessage = "";
		
		try {
		
			DataBase.insertNewMember(fullNameField.getText(), cpfField.getText(), 
			   rgField.getText(), cityField.getText(), addressField.getText(), 
			    postalCodeField.getText(), phoneField.getText(), emailField.getText(), 
			    birthdayField.getText(), Integer.parseInt(ageField.getText()), 
			    contractBox.getValue(), paymentTypeBox.getValue(), paymentStatus);
			
				/*
				if (fullNameField.getText() == null || fullNameField.getText().length() == 0) {
					errorMessage += "Nome inválido!\n"; 
				}
		
				if (cpfField.getText() == null || cpfField.getText().length() == 0) {
					errorMessage += "CPF inválido!\n"; 
				}
		
				if (rgField.getText() == null || rgField.getText().length() == 0) {
					errorMessage += "RG inválido!\n"; 
				}
		
				if (cityField.getText() == null || cityField.getText().length() == 0) {
					errorMessage += "Cidade inválida!\n"; 
				}
		
				if (addressField.getText() == null || addressField.getText().length() == 0) {
					errorMessage += "Endereço inválida!\n"; 
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
		
				if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
				     errorMessage += "Invalid birthday!\n"; 
				}
		
				if (ageField.getText() == null || ageField.getText().length() == 0) {
					errorMessage += "Invalid age!\n"; 
				}
	
				if (errorMessage.length() == 0) {
					return true;
				} 
			}*/
		}
		
		catch(Exception e) {
			System.out.print(e);
			
			Alert alert2 = new Alert(AlertType.ERROR);
			alert2.setTitle("Campos Inválidos");
			alert2.setHeaderText("Por favor, corrija os campos inválidos");
			alert2.setContentText(errorMessage);
			alert2.showAndWait();

			return false;
		}
		
		return false;
	}

	public void setMainApp (MainApp mainApp){
		this.mainApp = mainApp;
	}
}