package com.vidyanidhi.computerseekho.entities;
import java.sql.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Receipt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int receipt_id;
	private Date receipt_date;
	private double receipt_amount;
	private Payment payment_id;
	
	public int getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}
	public Date getReceipt_date() {
		return receipt_date;
	}
	public void setReceipt_date(Date receipt_date) {
		this.receipt_date = receipt_date;
	}
	public double getReceipt_amount() {
		return receipt_amount;
	}
	public void setReceipt_amount(double receipt_amount) {
		this.receipt_amount = receipt_amount;
	}
	public Payment getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Payment payment_id) {
		this.payment_id = payment_id;
	}

}