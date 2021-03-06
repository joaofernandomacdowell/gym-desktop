package br.com.joao.gym.view;

import java.sql.SQLException;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.conection.DataBase;
import br.com.joao.gym.model.ItemSeries;
import br.com.joao.gym.model.Member;
import br.com.joao.gym.model.Series;
import br.com.joao.gym.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

public class CreateSeriesController {

	//Input
	@FXML
	private TextField memberCpfField;

	@FXML
	private Label memberNameLabel;

	@FXML
	private ChoiceBox<String> workoutBox;

	@FXML
	private Button addButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button backButton;

	@FXML
	private DatePicker dateStart;
	@FXML
	private DatePicker dateEnd;

	//Table View
	@FXML
	private TableView<ItemSeries> table;

	//Column's Table (interface only)
	@FXML
	private TableColumn<ItemSeries, String> timesColumn;
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
	/*@FXML
	private TextField numField;*/
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
	
	boolean workout_a = false;
    boolean workout_b = false;
    boolean workout_c = false;

	ObservableList<ItemSeries> itensList = FXCollections.observableArrayList();
	ObservableList<String> workoutList = FXCollections.observableArrayList(
			"A", "B", "C"
			);

	User user;
	Series series = new Series();
	Member member;
	ItemSeries itemSeries;
	MainApp mainApp;

	@FXML
	private void initialize() {
		workoutBox.setValue("A");
		workoutBox.setItems(workoutList);

		table.setVisible(false);
		hideLabels();
		hideButtons();
		hideFields();
	}

	//Access Member button clicked
	@FXML
	private void handleAccessMember() throws SQLException, Exception {
		if (isCpfValid()) {
			series.setMemberCpf(member.getCpf());

			showLabels();

			memberNameLabel.setText(member.getFullName());

			System.out.println(series.getMemberCpf());		
		}	
	}

	//Select Workout button clicked
	@FXML
	private void handleSelectWorkout() throws Exception {
		System.out.println("workoutBox value: " + workoutBox.getValue());
		//System.out.println("workBox value: " + );
		if(workoutBox.getValue().equals("A")) {
			workout_a = true;
		}

		else if(workoutBox.getValue().equals("B")) {
			workout_b = true;
		}

		else if(workoutBox.getValue().equals("C")) {
			workout_c = true;
		}

		DataBase.insertSeries(series.getMemberCpf(), workout_a, workout_b, workout_c, dateStart, dateEnd);

		loadColumns();
		table.setItems(getItemSeries());
		
		table.setVisible(true);

		showButtons();
		showFields();
	}

	//Add Exercise button clicked
	@FXML
	private void handleAddItem() throws SQLException, Exception {
		ItemSeries itemSeries = new ItemSeries();

		itemSeries.setExerciseName(exerciseField.getText());
		itemSeries.setEquipment(equipmentField.getText());
		itemSeries.setQtdSeries(qtdSeriesField.getText());
		itemSeries.setReps(repsField.getText());
		itemSeries.setWeight(weightField.getText());
		itemSeries.setRegulation(regulationField.getText());
		itemSeries.setObs(obsField.getText());	

		table.getItems().add(itemSeries);

		DataBase.insertItemSeries(series.getMemberCpf(), series.getId(), workoutBox.getValue(), itemSeries.getTimesExecuted(), 
				itemSeries.getExerciseName(), itemSeries.getEquipment(), itemSeries.getQtdSeries(), 
				itemSeries.getReps(), itemSeries.getWeight(), itemSeries.getRegulation(), 
				itemSeries.getObs());

		clearFields();
	}

	//Delete Exercise button clicked
	@FXML
	private void handleDeleteItem() {
		ObservableList<ItemSeries> itemSelected, allItens;

		allItens = table.getItems();
		itemSelected = table.getSelectionModel().getSelectedItems();

		itemSelected.forEach(allItens::remove);
	}

	//Back button clicked
	@FXML
	private void handleBack() throws Exception {
		mainApp.showMenuInstructor(user);
	}

	public void loadColumns() {
		timesColumn.setCellValueFactory(new PropertyValueFactory<>("timesExecuted"));
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

	private void hideButtons() {
		addButton.setVisible(false);
		deleteButton.setVisible(false);
		backButton.setVisible(false);
	}

	private void showButtons() {
		addButton.setVisible(true);
		deleteButton.setVisible(true);
		backButton.setVisible(true);
	}

	private void hideLabels() {
		memberNameLabel.setVisible(false);
	}

	private void showLabels() {
		memberNameLabel.setVisible(true);
	}

	private void clearFields() {
		exerciseField.clear();
		equipmentField.clear();
		repsField.clear();
		qtdSeriesField.clear();
		weightField.clear();
		regulationField.clear();
		obsField.clear();
	}
	
	private void hideFields() {
		exerciseField.setVisible(false);
		equipmentField.setVisible(false);
		qtdSeriesField.setVisible(false);
		repsField.setVisible(false);
		weightField.setVisible(false);
		regulationField.setVisible(false);
		obsField.setVisible(false);
	}
	
	private void showFields() {
		exerciseField.setVisible(true);
		equipmentField.setVisible(true);
		qtdSeriesField.setVisible(true);
		repsField.setVisible(true);
		weightField.setVisible(true);
		regulationField.setVisible(true);
		obsField.setVisible(true);
	}


	private boolean isCpfValid() {
		try {
			member = DataBase.getMember(memberCpfField.getText());

			if (memberCpfField.getText().equals(member.getCpf())) {
				System.out.println("cpf encontrado: " + member.getCpf());
				series.setMemberCpf(member.getCpf());
				
				return true;
			}

			else {
				Alert alert = new Alert(AlertType.ERROR);

				alert.setTitle("Invalid CPF");
				alert.setHeaderText("This CPF is not registred");
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
