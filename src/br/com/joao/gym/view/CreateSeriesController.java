package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.conection.DataBase;
import br.com.joao.gym.model.ItemSeries;
import br.com.joao.gym.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

public class CreateSeriesController {

	//Table View
	@FXML
	private TableView<ItemSeries> table;
	
	//Column's Table (interface only)
	@FXML
	private TableColumn<ItemSeries, String> numColumn;
	@FXML
	private TableColumn<ItemSeries, String> exerciseColumn;
	@FXML
	private TableColumn<ItemSeries, String> equipmentColumn;
	@FXML
	private TableColumn<ItemSeries, String> qtdSeriesColumn;
	@FXML
	private TableColumn<ItemSeries, String> repsColumn;
	@FXML
	private TableColumn<ItemSeries, String> weightColumn;
	@FXML
	private TableColumn<ItemSeries, String> regulationColumn;
	@FXML
	private TableColumn<ItemSeries, String> obsColumn;

	//TextFields (for adding and delete rows of the Table
	@FXML
	private TextField numField;
	@FXML
	private TextField exerciseField;
	@FXML
	private TextField equipmentField;
	@FXML
	private TextField qtdSeriesField;
	@FXML
	private TextField repsField;
	@FXML
	private TextField weightField;
	@FXML
	private TextField regulationField;
	@FXML
	private TextField obsField;
	
	@FXML
	private Label userNameLabel;
	
	ObservableList<ItemSeries> itensList = FXCollections.observableArrayList(
			new ItemSeries(1, "Supino Reto", "12", "4", "10-12", "25", "0", ""),
			new ItemSeries(2, "Supino Inclinado com halteres", "13", "3", "8-10", "24", "45", ""));

	private User user;
	private MainApp mainApp;
	
	@FXML
	private void initialize() {
		loadColumns();
		table.setItems(getItemSeries());
	}

	//Add Exercise button clicked
	@FXML
	private void handleAddExercise() {
		ItemSeries itemSeries = new ItemSeries();
		
		itemSeries.setExerciseNum(Integer.parseInt(numField.getText()));
		itemSeries.setExerciseName(exerciseField.getText());
		itemSeries.setEquipment(equipmentField.getText());
		itemSeries.setReps(repsField.getText());
		itemSeries.setQtdSeries(qtdSeriesField.getText());
		itemSeries.setRegulation(regulationField.getText());
		itemSeries.setObs(obsField.getText());	
		
		table.getItems().add(itemSeries);
		
		clearFields();
	}
	
	//Delete Exercise button clicked
	@FXML
	private void handleDeleteExercise() {
		ObservableList<ItemSeries> itemSelected, allItens;
		
		allItens = table.getItems();
		itemSelected = table.getSelectionModel().getSelectedItems();
		
		itemSelected.forEach(allItens::remove);
	}
	
	//Register Series button clicked
	/*
	@FXML
	private void handleRegisterSeries() {
		
		Alert alertSucess = new Alert(AlertType.CONFIRMATION);
		
		try {
			DataBase.insertSeries();
			
			//localDate = new LocalDate(, 0, 0);
			//String payDate = DateUtil.format(dateBirthField.getValue());
			
			alertSuccess.showAndWait();
			alertSuccess.setTitle("User Registred!");
			alertSuccess.setContentText("User Registred Successfully");
	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}*/
	
	//Back button clicked
	@FXML
	private void handleBack() throws Exception {
		mainApp.showMenuInstructor(user);
	}
	
	public void loadColumns() {

		numColumn.setCellValueFactory(new PropertyValueFactory<>("exerciseNum"));
		exerciseColumn.setCellValueFactory(new PropertyValueFactory<>("exerciseName"));
		equipmentColumn.setCellValueFactory(new PropertyValueFactory<>("equipment"));
		qtdSeriesColumn.setCellValueFactory(new PropertyValueFactory<>("qtdSeries"));
		repsColumn.setCellValueFactory(new PropertyValueFactory<>("reps"));
		weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
		regulationColumn.setCellValueFactory(new PropertyValueFactory<>("regulation"));
		obsColumn.setCellValueFactory(new PropertyValueFactory<>("obs"));
		
		/*table.getColumns().addAll(numColumn, exerciseColumn, equipmentColumn, 
				qtdSeriesColumn, repsColumn, weightColumn, regulationColumn, obsColumn);*/
	}
	
	
	private void clearFields() {
		numField.clear();
		exerciseField.clear();
		equipmentField.clear();
		repsField.clear();
		qtdSeriesField.clear();
		weightField.clear();
		regulationField.clear();
		obsField.clear();
	}
	
	public ObservableList<ItemSeries> getItemSeries() {		
		return itensList;
	}
	
	/*
	public void loadColumnsByCells() {
		numColumn.setCellValueFactory(cellData -> cellData.getValue().exerciseNumProperty());
		exerciseColumn.setCellValueFactory(cellData -> cellData.getValue().exerciseNameProperty());
		equipmentColumn.setCellValueFactory(cellData -> cellData.getValue().equipmentProperty());
		qtdSeriesColumn.setCellValueFactory(cellData -> cellData.getValue().qtdSeriesProperty());
		repsColumn.setCellValueFactory(cellData -> cellData.getValue().repsProperty());
		weightColumn.setCellValueFactory(cellData -> cellData.getValue().weightProperty());
		regulationColumn.setCellValueFactory(cellData -> cellData.getValue().regulationProperty());
		obsColumn.setCellValueFactory(cellData -> cellData.getValue().obsProperty());
	}
	 */
	
	public void setCreateSeries(User user) {
		this.user = user;
		userNameLabel.setText(user.getUserName());
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
