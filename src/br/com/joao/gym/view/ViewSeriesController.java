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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewSeriesController {

	//Input
	@FXML
	private TextField memberCpfField;

	//Member info
	@FXML
	private Label dateStartLabel;
	@FXML
	private Label dateEndLabel;
	@FXML
	private Label startsLabel;
	@FXML
	private Label endsLabel;

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
	private Button addButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button execItem;
	@FXML
	private Button updateSeriesButton;
	@FXML
	private Button backButton;
	
	private String cpf, workout;
	private int id_series;
	ObservableList<ItemSeries> itemList = FXCollections.observableArrayList();

	User user;
	Series series;
	ItemSeries itemSeries;
	Member member;
	MainApp mainApp;

	//User that is loged
	@FXML
	private Label userNameLabel;

	@FXML
	private void initialize() {
		table.setVisible(false);
		hideLabels();
		hideButtons();
		hideFields();
	}

	//Access Member button clicked
	@FXML
	private void handleAccessMember() throws SQLException, Exception {
		if (isInputValid()) {
			series.setMemberCpf(memberCpfField.getText());
			
			showLabels();
			
			loadColumns();
			itemSeries = DataBase.getItemSeries(series.getMemberCpf(), "A", itemList);
			
			cpf = itemSeries.getMemberCpf();
			id_series = itemSeries.getIdSerie();
			workout = itemSeries.getWorkout();
			
			table.setItems(itemList);
			table.setVisible(true);
			showButtons();
			showLabels();
			showFields();
			
			System.out.println(series.getMemberCpf());		
		}	
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

		DataBase.insertItemSeries(cpf, id_series, workout, itemSeries.getTimesExecuted(), 
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

	//Update button clicked
	@FXML
	private void handleExecItem() throws Exception {
		
		table.setOnMouseClicked(e-> {
			try {
				ItemSeries itemSeries = (ItemSeries)table.getSelectionModel().getSelectedItem();
				DataBase.getSingleItemSeries(itemSeries.getIdItem());
			}
			
			catch(Exception er) {
				System.out.println(er);
			}
		});
		
		int timesExecuted = itemSeries.getTimesExecuted();
		timesExecuted++;
		
		DataBase.updateItemTimesExecuted(timesExecuted, itemSeries.getIdItem());
	}
	
	@FXML
	private void handleUpdateSeries() throws SQLException, Exception {
	}

	//Back button clicked
	@FXML
	private void handleBack() throws Exception {
		mainApp.showMenuInstructor(user);
	}

	private boolean isInputValid() {
		try {
			series = DataBase.getSeries(memberCpfField.getText());

			if (memberCpfField.getText().equals(series.getMemberCpf())) {	
				dateStartLabel.setText(series.getDateStart());
				dateEndLabel.setText(series.getDateEnd());
				return true;
			}

			else {
				Alert alert = new Alert(AlertType.ERROR);
				
				alert.setTitle("Invalid CPF");
				alert.setHeaderText("This CPF does not have registered series");
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
		updateSeriesButton.setVisible(false);
		execItem.setVisible(false);
	}

	private void showButtons() {
		addButton.setVisible(true);
		deleteButton.setVisible(true);
		updateSeriesButton.setVisible(true);
		execItem.setVisible(true);
	}

	private void hideLabels() {
		startsLabel.setVisible(false);
		endsLabel.setVisible(false);
		dateStartLabel.setVisible(false);
		dateEndLabel.setVisible(false);
	}

	private void showLabels() {
		startsLabel.setVisible(true);
		endsLabel.setVisible(true);
		dateStartLabel.setVisible(true);
		dateEndLabel.setVisible(true);
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

	public void setViewSeries(User user) {
		this.user = user;
		userNameLabel.setText(user.getUserName());
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}