package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.model.Series;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class CreateSeriesController {

	MainApp mainApp;
	Series series;
	private final ObservableList<Series> data =
			FXCollections.observableArrayList();

	@FXML
	private TableColumn<Series, Integer> id;
	@FXML
	private TableColumn<Series, Integer> exerciseNum;
	@FXML
	private TableColumn<Series, String> exerciseName;
	@FXML
	private TableColumn<Series, String> equipmentNum;
	@FXML
	private TableColumn<Series, String> seriesNum;
	@FXML
	private TableColumn<Series, String> reps;
	@FXML
	private TableColumn<Series, String> weight;
	@FXML
	private TableColumn<Series, String> regulation;
	@FXML
	private TableColumn<Series, String> obs;
	//@FXML
	//private TableColumn<Series, String> training;

	@FXML
	private void initialize(){ 
		loadTable();
	}

	private void loadTable(){
		//data.add(temp);	

		//series.setItems(data);

		//id.setCellValueFactory(new PropertyValueFactory<Series, Integer>("id"));
		//exerciseNum.setCellValueFactory(new PropertyValueFactory<Series, String>("signature"));
		//exerciseName.setCellValueFactory(new PropertyValueFactory<Series, String>("secretName"));
		//codeColumn.setCellValueFactory(new PropertyValueFactory<Series, String>("name"));
		//statColumn.setCellValueFactory(new PropertyValueFactory<Series, String>("status"));
	}



	//@FXML
	//private boolean handleAddExercise() {

	//	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
