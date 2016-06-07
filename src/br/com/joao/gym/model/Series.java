package br.com.joao.gym.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Series {

	private final IntegerProperty id;
	private final StringProperty memberCpf;
	private final IntegerProperty exerciseNum;
	private final StringProperty exerciseName; 
	private final IntegerProperty equipmentNum;
	private final StringProperty series;
	private final StringProperty reps;
	private final StringProperty weight;
	private final StringProperty regulation;
	private final StringProperty obs;
	private final ObjectProperty<LocalDate> dateStart;
	private final ObjectProperty<LocalDate> dateEnd;


	public Series() { 
		this(0, null, 0, null, 0, null, null, null, null, null, null, null); 
	}


	public Series(int id, String memberCpf, int exerciseNum, String exerciseName, 
			int equipmentNum, String series, String reps, String weight, 
			String regulation, String obs, LocalDate dateStart, LocalDate dateEnd) {

		this.id = new SimpleIntegerProperty(id);
		this.memberCpf = new SimpleStringProperty(memberCpf);
		this.exerciseNum = new SimpleIntegerProperty(exerciseNum);
		this.exerciseName = new SimpleStringProperty(exerciseName);
		this.equipmentNum = new SimpleIntegerProperty(equipmentNum);
		this.series = new SimpleStringProperty(series);
		this.reps = new SimpleStringProperty(reps);
		this.weight = new SimpleStringProperty(weight);
		this.regulation= new SimpleStringProperty(regulation);
		this.obs = new SimpleStringProperty(obs);
		this.dateStart = new SimpleObjectProperty<LocalDate>(dateStart);
		this.dateEnd = new SimpleObjectProperty<LocalDate>(dateEnd);
	}

	//id methods
	public int getId() {
		return id.get();
	} 

	public void setId(int id) {
		this.id.set(id);
	}

	public IntegerProperty fullNameProperty() {
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
	//end: memberCPF methods


	//exerciseNum methods
	public int getExerciseNum() {
		return exerciseNum.get();
	}

	public void setExerciseNum(int exerciseNum) {
		this.exerciseNum.set(exerciseNum);
	}

	public IntegerProperty exerciseNumProperty() {
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
	public Integer getEquipmentNum() {
		return equipmentNum.get();
	} 

	public void setEquipmentNum(int equipmentNum) {
		this.equipmentNum.set(equipmentNum);
	}

	public IntegerProperty equipmentNumProperty() {
		return equipmentNum;
	}
	//end: equipmentNum methods


	//series methods
	public String getSeries() {
		return series.get();
	}

	public void setPostalCode(String series) {
		this.series.set(series);
	}

	public StringProperty seriesProperty() {
		return series;
	}
	//end: series methods


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

	public StringProperty obsStringProperty() {
		return obs;
	}	
	//end: obs methods

	
	//dateStart methods
	public LocalDate getDateStart() {
		return dateStart.get();
	} 

	public void setDateStart(LocalDate dateStart) {
		this.dateStart.set(dateStart);
	}

	public ObjectProperty<LocalDate> datesStartProperty() {
		return dateStart;
	}	
	//end: dateStart methods

	
	//dateEnd methods
	public LocalDate getDateEnd() {
		return dateEnd.get();
	} 

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd.set(dateEnd);
	}

	public ObjectProperty<LocalDate> datesEndProperty() {
		return dateEnd;
	}	
	//end: dateEnd methods

}
