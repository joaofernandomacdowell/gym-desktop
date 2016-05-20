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
    private TextField adressField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    
    
    //Personal Informations
    
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private TextField ageField;
    
    
    //Contract and Payment
    
    @FXML
    private ComboBox<String> contractBox; 
    @FXML
    private ComboBox<String> paymentBox;
    
    
    //Recepcionist that is logged
    
    @FXML
    private Label userNameLabel1;
    @FXML
    private Tab userNameLabel2;
    @FXML
    private Tab userNameLabel3;
    
    private Member member;
    private boolean registerClicked = false;
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
    	
    	paymentBox.setItems(paymentList);
    	
    	//calculateAge();
    }

    private void calculateAge() {
    	Calendar now = Calendar.getInstance();
    	int year = now.get(Calendar.YEAR);
    	int birthYear = dateOfBirth.getValue().getYear();
    	int age = year - birthYear;
    	ageField.setText(Integer.toString(age) + " years");
    }
    
    
    public void setMember(Member member) throws Exception {
    	
        this.member = member;

        fullNameField.setText(member.getFullName());
        cpfField.setText(Integer.toString(member.getCpf()));
        rgField.setText(Integer.toString(member.getRg()));
        cityField.setText(member.getCity());
        
        adressField.setText(member.getCity());
        postalCodeField.setText(Integer.toString(member.getPostalCode()));
        phoneField.setText(Integer.toString(member.getPhone()));
        emailField.setText(member.getEmail());
        
        //birthday.setText(DateUtil.format(member.getBirth()));
        //birthdayField.setPromptText("dd.mm.yyyy");
       
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
            member.setAdress(adressField.getText());
            //member.setPostalCode(Integer.parseInt(postalCodeField.getText()));
            //member.setCity(cityField.getText());
            //member.setBirthday(DateUtil.parse(birthdayField.getText()));

            registerClicked = true;
            
            System.out.println("");
            
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

        if (fullNameField.getText() == null || fullNameField.getText().length() == 0) {
            errorMessage += "Nome inválido!\n"; 
        }
        
        if (cpfField.getText() == null || cpfField.getText().length() == 0) {
            errorMessage += "Sobrenome inválido!\n"; 
        }
        
        if (rgField.getText() == null || rgField.getText().length() == 0) {
            errorMessage += "Rua inválida!\n"; 
        }
        
        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "Cidade inválida!\n"; 
        }
        
        if (adressField.getText() == null || adressField.getText().length() == 0) {
            errorMessage += "Endereço inválida!\n"; 
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "Código Postal inválido!\n"; 
        } 
        
        else {
            // tenta converter o código postal em um int.
            try {
                Integer.parseInt(postalCodeField.getText());
            } 
            
            catch (NumberFormatException e) {
                errorMessage += "Código Postal inválido (deve ser um inteiro)!\n"; 
            }
        }

        /*
        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "Aniversário inválido!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "Aniversário inválido. Use o formato dd.mm.yyyy!\n";
            }
        }
		*/
        if (errorMessage.length() == 0) {
            return true;
        } 
        
        else {
            // Mostra a mensagem de erro.
            Alert alert = new Alert(AlertType.ERROR);
                      alert.setTitle("Campos Inválidos");
                      alert.setHeaderText("Por favor, corrija os campos inválidos");
                      alert.setContentText(errorMessage);
                alert.showAndWait();

            return false;
        }
    }
    
    public void setMainApp (MainApp mainApp){
    	this.mainApp = mainApp;
    }
}