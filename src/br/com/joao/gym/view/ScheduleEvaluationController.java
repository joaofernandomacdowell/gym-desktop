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

	private int id = 0;

	private MainApp mainApp;
	private Evaluation evaluation = new Evaluation();

	@FXML
	private void initialize() { 

	}

	public void setEvaluation(Evaluation evaluation) throws Exception {

		this.evaluation = evaluation;

		memberCpfField.setText(evaluation.getMemberCpf());

		/*
		if (evaluation.getDate() != null) {
		    datePicker.setValue(evaluation.getDate());
		} 

		else {
		    datePicker.setValue(null);
		}*/

		timeField.setText(evaluation.getTime());
		instructorNameField.setText(evaluation.getTime());
	}

	@FXML
	private void handleConfirm() throws Exception {

		try {

			if(isInputValid()) {
				id = incrementId (evaluation.getId());
			}

			else {
				id = 0;
			}

			DataBase.insertEvaluation(id, memberCpfField.getText(), datePicker, 
					timeField.getText(), instructorNameField.getText());
		}

		catch(Exception e) {
			System.out.println(e);
		}
	}

	private boolean isInputValid() {

		try {

			evaluation = DataBase.getEvaluationLastId(id);
			//evaluation = DataBase.getLastId();
			System.out.println("Encontrou o LastId no banco: " + evaluation.getId());
			return true;
		}

		catch(Exception e) {
			System.out.println("Não encontrou o LastId no banco.");
			System.out.println(e);
			return false;
		}
	}

	private int incrementId(int id) {
		return id++;
	}

	@FXML
	private void handleBack() throws Exception {
		mainApp.showMenuReceptionist();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
