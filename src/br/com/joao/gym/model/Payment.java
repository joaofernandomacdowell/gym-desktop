package br.com.joao.gym.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Payment {

	public final BooleanProperty january;
	public final BooleanProperty february;
	public final BooleanProperty march;
	public final BooleanProperty april;
	public final BooleanProperty may;
	public final BooleanProperty june;
	public final BooleanProperty july;
	public final BooleanProperty august;
	public final BooleanProperty september;
	public final BooleanProperty octuber;
	public final BooleanProperty november;
	public final BooleanProperty december;

	private final StringProperty memberCpf;


	public Payment(){
		this(false, false, false, false, false, false, false, false, false, false, 
				false, false, null);
	}

	public Payment(boolean january, boolean february, boolean march, boolean april, boolean may,
			boolean june, boolean july, boolean august, boolean september, boolean octuber,
			boolean november, boolean december, String memberCpf){

		this.january = new SimpleBooleanProperty(january);
		this.february = new SimpleBooleanProperty(february);
		this.march = new SimpleBooleanProperty(march);
		this.april = new SimpleBooleanProperty(april);
		this.may = new SimpleBooleanProperty(may);
		this.june = new SimpleBooleanProperty(june);
		this.july = new SimpleBooleanProperty(july);
		this.august = new SimpleBooleanProperty(august);
		this.september = new SimpleBooleanProperty(september);
		this.octuber = new SimpleBooleanProperty(octuber);
		this.november = new SimpleBooleanProperty(november);
		this.december = new SimpleBooleanProperty(december);

		this.memberCpf = new SimpleStringProperty(memberCpf);
	}

	// january methods
	public Boolean getJanuary() {
		return january.get();
	}

	public void setJanuary(Boolean january) {
		this.january.set(january);
	}

	public BooleanProperty januaryProperty() {
		return january;
	}
	//end: january methods


	//february methods
	public Boolean getFebruary() {
		return february.get();
	}

	public void setFebruary(Boolean february) {
		this.february.set(february);
	}

	public BooleanProperty februaryProperty() {
		return february;
	}
	//end: february methods


	//march methods
	public Boolean getMarch() {
		return march.get();
	}

	public void setMarch(Boolean march) {
		this.march.set(march);
	}

	public BooleanProperty marchProperty() {
		return march;
	}
	//end: march methods


	//april methods
	public Boolean getApril() {
		return april.get();
	}

	public void setUserName(Boolean april) {
		this.april.set(april);
	}

	public BooleanProperty aprilProperty() {
		return april;
	}
	//end: april methods


	//may methods
	public Boolean getMay() {
		return may.get();
	}

	public void setMay(Boolean may) {
		this.may.set(may);
	}

	public BooleanProperty mayProperty() {
		return may;
	}
	//end: may methods


	//june methods
	public Boolean getJune() {
		return june.get();
	}

	public void setJune(Boolean june) {
		this.june.set(june);
	}

	public BooleanProperty juneProperty() {
		return june;
	}
	//end: june methods


	//july methods
	public Boolean getJuly() {
		return july.get();
	}

	public void setJuly(Boolean july) {
		this.july.set(july);
	}

	public BooleanProperty julyProperty() {
		return july;
	}
	//end: july methods


	//august methods
	public Boolean getAugust() {
		return august.get();
	}

	public void setAugust(Boolean august) {
		this.august.set(august);
	}

	public BooleanProperty augustProperty() {
		return august;
	}
	//end: august methods


	//september methods
	public Boolean getSeptember() {
		return september.get();
	}

	public void setSeptember(Boolean september) {
		this.september.set(september);
	}

	public BooleanProperty septemberProperty() {
		return september;
	}
	//end: september methods


	//octuber methods
	public Boolean getOctuber() {
		return octuber.get();
	}

	public void setOctuber(Boolean octuber) {
		this.octuber.set(octuber);
	}

	public BooleanProperty octuberProperty() {
		return octuber;
	}
	//end: octuber methods


	//november methods
	public Boolean getNovember() {
		return november.get();
	}

	public void setNovember(Boolean november) {
		this.november.set(november);
	}

	public BooleanProperty novemberProperty() {
		return november;
	}
	//end: november methods


	//december methods
	public Boolean getDecember() {
		return december.get();
	}

	public void setDecember(Boolean december) {
		this.december.set(december);
	}

	public BooleanProperty decemberProperty() {
		return december;
	}
	//end: december methods
}