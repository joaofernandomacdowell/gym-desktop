package br.com.joao.gym.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.model.Member;
import br.com.joao.gym.util.DateUtil;
//import ch.makery.address.util.DateUtil;


public class RegisterMemberController {

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
    private TextField telephoneField;
    @FXML
    private TextField birthField;
    @FXML
    private TextField email;
    @FXML
    private ComboBox<String> contractBox; 
    @FXML
    private Label userNameLabel;
    
    private Member member;
    private boolean registerClicked = false;
	private MainApp mainApp;

    
     //Inicializa a classe controlle. Este m�todo � chamado automaticamente
    // ap�s o arquivo fxml ter sido carregado.
     
    @FXML
    private void initialize() {
    }

    
    public void setMember(Member member) throws Exception {
    	
        this.member = member;

        fullNameField.setText(member.getFullName());
        cpfField.setText(Integer.toString(member.getCpf()));
        rgField.setText(Integer.toString(member.getRg()));
        cityField.setText(member.getCity());
        
        adressField.setText(member.getCity());
        postalCodeField.setText(Integer.toString(member.getPostalCode()));
        telephoneField.setText(Integer.toString(member.getTelephone()));
       //birthField.setText(DateUtil.format(member.getBirth()));
        birthField.setPromptText("dd.mm.yyyy");
        contractBox.getItems().addAll("Smart", "Black");
        
    }

    /**
     * Retorna true se o usu�rio clicar OK,caso contr�rio false.
     * 
     * @return
     */
    public boolean isRegisterClicked() {
        return registerClicked;
    }

    /**
     * Chamado quando o usu�rio clica Register.
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

     //Chamado quando o usu�rio clica Back.
    @FXML
    private void handleBack() {
    }
    
    //Chamado quando o usu�rio clica em LogOut
    @FXML
    private void handleLogOut(){	
    }

    /**
     * Valida a entrada do usu�rio nos campos de texto.
     * 
     * @return true se a entrada � v�lida
     */
    private boolean isInputValid() {

        String errorMessage = "";

        if (fullNameField.getText() == null || fullNameField.getText().length() == 0) {
            errorMessage += "Nome inv�lido!\n"; 
        }
        
        if (cpfField.getText() == null || cpfField.getText().length() == 0) {
            errorMessage += "Sobrenome inv�lido!\n"; 
        }
        
        if (rgField.getText() == null || rgField.getText().length() == 0) {
            errorMessage += "Rua inv�lida!\n"; 
        }
        
        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "Cidade inv�lida!\n"; 
        }
        
        if (adressField.getText() == null || adressField.getText().length() == 0) {
            errorMessage += "Endere�o inv�lida!\n"; 
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "C�digo Postal inv�lido!\n"; 
        } 
        
        else {
            // tenta converter o c�digo postal em um int.
            try {
                Integer.parseInt(postalCodeField.getText());
            } 
            
            catch (NumberFormatException e) {
                errorMessage += "C�digo Postal inv�lido (deve ser um inteiro)!\n"; 
            }
        }

        /*
        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "Anivers�rio inv�lido!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "Anivers�rio inv�lido. Use o formato dd.mm.yyyy!\n";
            }
        }
		*/
        if (errorMessage.length() == 0) {
            return true;
        } 
        
        else {
            // Mostra a mensagem de erro.
            Alert alert = new Alert(AlertType.ERROR);
                      alert.setTitle("Campos Inv�lidos");
                      alert.setHeaderText("Por favor, corrija os campos inv�lidos");
                      alert.setContentText(errorMessage);
                alert.showAndWait();

            return false;
        }
    }
    
    public void setMainApp (MainApp mainApp){
    	this.mainApp = mainApp;
    }
}