package br.com.joao.gym.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pay {

	private final StringProperty memberCpf;
	private final StringProperty mounthly;
	private final DoubleProperty amount;
	private final BooleanProperty paymentStatus;
	
	public Pay() {
		this(null, null, 0.0, false);
	}

	public Pay(String memberCpf, String mounthly, Double amount, boolean paymentStatus){
		this.memberCpf = new SimpleStringProperty (memberCpf);
		this.mounthly = new SimpleStringProperty (mounthly);
		this.amount = new SimpleDoubleProperty (amount);
		this.paymentStatus = new SimpleBooleanProperty(paymentStatus);
	}

	// memberCpf methods
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


	//mouthly methods
	public String getMounthly() {
		return mounthly.get();
	}

	public void setMounthly(String mounthly) {
		this.mounthly.set(mounthly);
	}

	public StringProperty mounthlyProperty() {
		return mounthly;
	}
	//end: mouthly methods


	//amount methods
	public Double getAmount() {
		return amount.get();
	}

	public void setAmount(Double amount) {
		this.amount.set(amount);
	}

	public DoubleProperty amountProperty() {
		return amount;
	}
	//end: amount methods


	//paymentStatus methods
	public boolean getPaymentStatus() {
		return paymentStatus.get();
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus.set(paymentStatus);
	}

	public BooleanProperty paymentStatusProperty() {
		return paymentStatus;
	}
	//end: paymentStatus methods
}