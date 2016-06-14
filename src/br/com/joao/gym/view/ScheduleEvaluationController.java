package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.conection.DataBase;
import br.com.joao.gym.model.Evaluation;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

public class ScheduleEvaluationController {

	//Member ScheduleEvaluation informations
	@FXML
	private TextField memberCpfField;
	@FXML
	private DatePicker datePicker;
	@FXML
	private TextField timeField;
	@FXML
	private TextField instructorNameField;
	
	private MainApp mainApp;
	private Evaluation evaluation = new Evaluation();

	@FXML
	private void initialize() { 
		
	}
	
	public void setEvaluation(Evaluation evaluation) throws Exception {

		this.evaluation = evaluation;

		memberCpfField.setText(evaluation.getMemberCpf());
		//datePicker.set
		timeField.setText(evaluation.getTime());
		instructorNameField.setText(evaluation.getTime());
	}
	
	@FXML
	private void handleConfirm() throws Exception {
		DataBase.insertNewEvaluation(memberCpfField.getText(), datePicker.getEditor().getText(), 
				timeField.getText(), instructorNameField.getText());
	}
	
	@FXML
	private void handleBack() throws Exception {
		mainApp.showMenuReceptionist();
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
