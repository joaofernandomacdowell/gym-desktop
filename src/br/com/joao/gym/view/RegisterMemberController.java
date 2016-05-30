package br.com.joao.gym.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.util.Calendar;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.conection.DataBase;
import br.com.joao.gym.model.Member;
import br.com.joao.gym.util.DateUtil;
//import ch.makery.address.util.DateUtil;


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


	//Recepcionist that is logged

	@FXML
	private Label userNameLabel1;
	@FXML
	private Tab userNameLabel2;
	@FXML
	private Tab userNameLabel3;

	private Member member;
	public boolean paymentStatus;
	private boolean registerClicked = false;
	private int registry;
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
		cpfField.setText(Integer.toString(member.getCpf()));
		rgField.setText(Integer.toString(member.getRg()));
		cityField.setText(member.getCity());

		addressField.setText(member.getCity());
		postalCodeField.setText(Integer.toString(member.getPostalCode()));
		phoneField.setText(Integer.toString(member.getPhone()));
		emailField.setText(member.getEmail());

		birthdayField.setText(member.getBirthday());
		birthdayField.setPromptText("dd.mm.yyyy");
		ageField.setText(Integer.toString(member.getAge()));
		
		contractBox.setValue(member.getContract());
		paymentTypeBox.setValue(member.getPaymentType());

		//teste
	}

	/**
	 * Retorna true se o usuário clicar OK,caso contrário false.
	 * 
	 * @return
	 */
	public boolean isRegisterClicked() {
		return registerClicked;
	}

	/**
	 * Chamado quando o usuário clica Register.
	 */
	@FXML
	private void handleRegister() {
		if (isInputValid()) {
			member.setFullName(fullNameField.getText());
			member.setCpf(Integer.parseInt(cpfField.getText()));
			member.setRg(Integer.parseInt(rgField.getText()));
			member.setCity(cityField.getText());
			member.setAddress(addressField.getText());
			member.setPostalCode(Integer.parseInt(postalCodeField.getText()));
			member.setPhone(Integer.parseInt(phoneField.getText()));
			member.setEmail(emailField.getText());
			member.setBirthday(birthdayField.getText());
			member.setAge(Integer.parseInt(ageField.getText()));
			member.setContract(contractBox.getValue());
			member.setPaymentType(paymentTypeBox.getValue());

			registerClicked = true;

			System.out.println("Entro na função");

			//entra nova scene
		}
	}

	//Chamado quando o usuário clica Back.
	@FXML
	private void handleBack() {
	}

	//Chamado quando o usuário clica em LogOut
	@FXML
	private void handleLogOut(){	
	}

	/**
	 * Valida a entrada do usuário nos campos de texto.
	 * 
	 * @return true se a entrada é válida
	 */
	private boolean isInputValid() {
		
		String errorMessage = "";
		
		try {
		
			if (DataBase.insertNewMember(fullNameField.getText(), Integer.parseInt(cpfField.getText()), 
			    Integer.parseInt(rgField.getText()), cityField.getText(), addressField.getText(), 
			    Integer.parseInt(postalCodeField.getText()), Integer.parseInt(phoneField.getText()), 
			    emailField.getText(), birthdayField.getText(), Integer.parseInt(ageField.getText()), 
			    contractBox.getValue(), paymentTypeBox.getValue())) {
				
				return true;
			}
		}
		
		catch(Exception e) {
			// Mostra a mensagem de erro.
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