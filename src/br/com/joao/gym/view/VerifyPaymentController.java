package br.com.joao.gym.view;

import java.sql.SQLException;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.conection.DataBase;
import br.com.joao.gym.model.ItemSeries;
import br.com.joao.gym.model.Member;
import br.com.joao.gym.model.Pay;
import br.com.joao.gym.model.Payment;
import br.com.joao.gym.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VerifyPaymentController {

	//Input
	@FXML
	private TextField cpfField;

	//Member info
	@FXML
	private Label memberNameLabel;
	@FXML
	private Label memberCpfLabel;
	@FXML
	private Label memberRgLabel;
	@FXML
	private Label memberAddressLabel;
	@FXML
	private Label memberPhoneLabel;
	@FXML
	private Label memberEmailLabel;

	//Table View
	@FXML
	private TableView<Pay> table;

	//Column's Table (interface only)
	//@FXML
	//private TableColumn<Pay, String> cpfColumn;
	@FXML
	private TableColumn<Pay, String> mounthlyColumn;
	@FXML
	private TableColumn<Pay, Double> amountColumn;
	@FXML
	private TableColumn<Pay, String> paymentStatusColumn;
	

	//User that is loged
	@FXML
	private Label userNameLabel;

	ObservableList<Pay> payList = FXCollections.observableArrayList();
	
	private User user;
	private Member member;
	private Pay pay;
	private MainApp mainApp;

	@FXML
	private void initialize() {
		table.setVisible(false);
		hideLabels();
	}

	@FXML
	private void handleSearch() throws Exception {	
		if (isInputValid()) {
			
			member.setCpf(cpfField.getText());
			
			memberNameLabel.setText(member.getFullName());
			memberCpfLabel.setText(member.getCpf());
			memberRgLabel.setText(member.getRg());
			memberAddressLabel.setText(member.getAddress());
			memberPhoneLabel.setText(member.getPhone());
			memberEmailLabel.setText(member.getEmail());
			
			showLabels();
			
			loadColumns();
			pay = DataBase.getPay(member.getCpf(), payList);
			table.setItems(payList);
			table.setVisible(true);
		}
		
		
	}

	@FXML
	private void handleBack() throws Exception {
		mainApp.showMenuReceptionist(user);
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
				//pay = DataBase.getPay(cpfField.getText(), payList);
				//table.setItems(payList);
				
				return true;
			}

			else {
				Alert alert = new Alert(AlertType.ERROR);
				
				alert.setTitle("Invalid CPF");
				alert.setHeaderText("This CPF is not registered");
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

	private void loadColumns() {
		mounthlyColumn.setCellValueFactory(new PropertyValueFactory<>("mounthly"));
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		paymentStatusColumn.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
	}
	
	private void hideLabels() {
		memberNameLabel.setVisible(false);
		memberCpfLabel.setVisible(false);
		memberRgLabel.setVisible(false);
		memberAddressLabel.setVisible(false);
		memberPhoneLabel.setVisible(false);
		memberEmailLabel.setVisible(false);
	}
	
	private void showLabels() {
		memberNameLabel.setVisible(true);
		memberCpfLabel.setVisible(true);
		memberRgLabel.setVisible(true);
		memberAddressLabel.setVisible(true);
		memberPhoneLabel.setVisible(true);
		memberEmailLabel.setVisible(true);
	}
	
	public void setVerifyPayment(User user) {
		this.user = user;
		userNameLabel.setText(user.getUserName());
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
