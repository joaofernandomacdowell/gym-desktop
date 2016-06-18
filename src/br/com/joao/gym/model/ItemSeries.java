package br.com.joao.gym.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemSeries {

	private final IntegerProperty id;
	private final StringProperty memberCpf;
	private final StringProperty training;
	private final StringProperty dateStart;
	private final StringProperty dateEnd;
	private final StringProperty exerciseNum;
	private final StringProperty exerciseName; 
	private final StringProperty equipment;
	private final StringProperty qtdSeries;
	private final StringProperty reps;
	private final StringProperty weight;
	private final StringProperty regulation;
	private final StringProperty obs;

	public ItemSeries() { 
		this(0, null, null, null, null, null, null, null, null, null, null, null, null); 
	}


	public ItemSeries(int id, String memberCpf, String training, String dateStart, String dateEnd, 
			String exerciseNum, String exerciseName, String equipment, String qtdSeries, 
			String reps, String weight, String regulation, String obs) {

		this.id = new SimpleIntegerProperty(id);
		this.memberCpf = new SimpleStringProperty(memberCpf);
		this.training = new SimpleStringProperty(training);
		this.dateStart = new SimpleStringProperty(dateStart);
		this.dateEnd = new SimpleStringProperty(dateEnd);

		this.exerciseNum = new SimpleStringProperty(exerciseNum);
		this.exerciseName = new SimpleStringProperty(exerciseName);
		this.equipment = new SimpleStringProperty(equipment);
		this.qtdSeries = new SimpleStringProperty(qtdSeries);
		this.reps = new SimpleStringProperty(reps);
		this.weight = new SimpleStringProperty(weight);
		this.regulation= new SimpleStringProperty(regulation);
		this.obs = new SimpleStringProperty(obs);
	}

	//id methods
	public int getId() {
		return id.get();
	} 

	public void setId(int id) {
		this.id.set(id);
	}

	public IntegerProperty idProperty() {
		return id;
	}
	//end: id methods


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


	//training methods
	public String getTraining() {
		return training.get();
	}

	public void setTraining(String training) {
		this.training.set(training);
	}

	public StringProperty trainingProperty() {
		return training;
	}
	//end: memberCPF methods


	//dateStart methods
	public String getDateStart() {
		return dateStart.get();
	}

	public void setDateStart(String dateStart) {
		this.dateStart.set(dateStart);
	}

	public StringProperty dateStartProperty() {
		return dateStart;
	}
	//end: memberCPF methods


	//dateEnd methods
	public String getDateEnd() {
		return dateEnd.get();
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd.set(dateEnd);
	}

	public StringProperty dateEndProperty() {
		return dateEnd;
	}
	//end: memberCpf methods

	
	//exerciseNum methods
	public String getExerciseNum() {
		return exerciseNum.get();
	}

	public void setExerciseNum(String exerciseNum) {
		this.exerciseNum.set(exerciseNum);
	}

	public StringProperty exerciseNumProperty() {
		return exerciseNum;
	}
	//end: exerciseNum methods


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
