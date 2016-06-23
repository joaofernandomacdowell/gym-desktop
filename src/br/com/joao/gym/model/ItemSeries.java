package br.com.joao.gym.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemSeries {

	private final StringProperty memberCpf;
	private final IntegerProperty idItem;
	private final IntegerProperty idSerie;
	private final StringProperty workout;

	private final IntegerProperty timesExecuted;
	private final StringProperty exerciseName; 
	private final StringProperty equipment;
	private final StringProperty qtdSeries;
	private final StringProperty reps;
	private final StringProperty weight;
	private final StringProperty regulation;
	private final StringProperty obs;

	public ItemSeries() { 
		this(null, 0, 0, null, 0, null, null, null, null, null, null, null); 
	}


	public ItemSeries(String memberCpf, int idItem, int idSerie, String workout,
			int timesExecuted, String exerciseName, String equipment, String qtdSeries, 
			String reps, String weight, String regulation, String obs) {

		this.memberCpf = new SimpleStringProperty(memberCpf);
		this.idItem = new SimpleIntegerProperty(idItem);
		this.idSerie = new SimpleIntegerProperty(idSerie);
		this.workout = new SimpleStringProperty(workout);

		this.timesExecuted = new SimpleIntegerProperty(timesExecuted);
		this.exerciseName = new SimpleStringProperty(exerciseName);
		this.equipment = new SimpleStringProperty(equipment);
		this.qtdSeries = new SimpleStringProperty(qtdSeries);
		this.reps = new SimpleStringProperty(reps);
		this.weight = new SimpleStringProperty(weight);
		this.regulation= new SimpleStringProperty(regulation);
		this.obs = new SimpleStringProperty(obs);
	}

	//memberCpf methods
	public String getMemberCpf() {
		return memberCpf.get();
	}

	public void setMemberCpf(String memberCpf) {
		this.memberCpf.set(memberCpf);
	}

	public StringProperty memberCpfProperty() {
		return memberCpf;
	}
	//end: memberCpf methods

	
	//idItem methods
	public int getIdItem() {
		return idItem.get();
	} 

	public void setIdItem(int idItem) {
		this.idItem.set(idItem);
	}

	public IntegerProperty idItemProperty() {
		return idItem;
	}
	//end: idItem methods

	//idSerie methods
	public int getIdSerie() {
		return idSerie.get();
	} 

	public void setIdSerie(int idSerie) {
		this.idSerie.set(idSerie);
	}

	public IntegerProperty idSerieProperty() {
		return idSerie;
	}
	//end: idSerie methods


	//workout methods
	public String getWorkout() {
		return workout.get();
	}

	public void setWorkout(String workout) {
		this.workout.set(workout);
	}

	public StringProperty workoutProperty() {
		return workout;
	}
	//end: workout methods


	//timesExecuted methods
	public int getTimesExecuted() {
		return timesExecuted.get();
	}

	public void setTimesExecuted(Integer timesExecuted) {
		this.timesExecuted.set(timesExecuted);
	}

	public IntegerProperty timesExecutedProperty() {
		return timesExecuted;
	}
	//end: timesExecuted methods


	//exerciseName methods
	public String getExerciseName() {
		return exerciseName.get();
	} 

	public void setExerciseName(String exerciseName) {
		this.exerciseName.set(exerciseName);
	}

	public StringProperty exerciseNameProperty() {
		return exerciseName;
	}
	//end: exerciseName methods


	//equipmentNum methods
	public String getEquipment() {
		return equipment.get();
	} 

	public void setEquipment(String equipment) {
		this.equipment.set(equipment);
	}

	public StringProperty equipmentProperty() {
		return equipment;
	}
	//end: equipmentNum methods


	//qtdSeries methods
	public String getQtdSeries() {
		return qtdSeries.get();
	}

	public void setQtdSeries(String qtdSeries) {
		this.qtdSeries.set(qtdSeries);
	}

	public StringProperty qtdSeriesProperty() {
		return qtdSeries;
	}
	//end: qtdSeries methods


	//reps methods
	public String getReps() {
		return reps.get();
	}

	public void setReps(String reps) {
		this.reps.set(reps);
	}

	public StringProperty repsProperty() {
		return reps;
	}
	//end: reps methods


	//weight methods
	public String getWeight() {
		return weight.get();
	} 

	public void setWeight(String weight) {
		this.weight.set(weight);
	}

	public StringProperty weightProperty() {
		return weight;
	}
	//end: weight methods


	//regulation methods
	public String getRegulation() {
		return regulation.get();
	} 

	public void setRegulation(String regulation) {
		this.regulation.set(regulation);
	}

	public StringProperty regulationProperty() {
		return regulation;
	}	
	//end: regulation methods


	//obs methods
	public String getObs() {
		return obs.get();
	} 

	public void setObs(String obs) {
		this.obs.set(obs);
	}

	public StringProperty obsProperty() {
		return obs;
	}	
	//end: obs methods
}
