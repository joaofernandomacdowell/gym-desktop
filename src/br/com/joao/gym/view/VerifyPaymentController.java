package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.conection.DataBase;
import br.com.joao.gym.model.Member;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VerifyPaymentController {
	
	@FXML
	private TextField cpfField;
	
	@FXML
	private Label memberNameLabel;
	@FXML
	private Label paymentStatusLabel;
	
	
	private MainApp mainApp;
	private Member member;

	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleSearch() throws Exception {	
		if (isInputValid()) {
			member.setCpf(member.getCpf());
			memberNameLabel.setText(member.getFullName());
			//paymentStatusLabel.setText(checkPaymentStatus());
		}
	}
	
	@FXML
	private void handleBack() throws Exception {
		mainApp.showMenuReceptionist();
	}
	
	/*private Boolean checkPaymentStatus () {
		if (member.getPaymentStatus() == true) {
			return "Paid";
		}
		
		else {
			return "Not Paid";
		}
	}*/
	
	private boolean isInputValid() {
		
		try {
			
			member = DataBase.getMember(cpfField.getText());
			
			if (cpfField.getText().equals(member.getCpf())) {
				System.out.println("Encontrou o cpf no banco");
				return true;
			}
			
			else {
				System.out.println("Não encontrou o cpf no banco");
				//inserir ALERT!!
				return false;
				
			}
		}
		
		catch(Exception e) {
			System.out.println("Entrou catch");
			System.out.println(e);
			return false;
		}
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
