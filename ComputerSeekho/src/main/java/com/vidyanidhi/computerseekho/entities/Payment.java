package com.vidyanidhi.computerseekho.entities;
import java.sql.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_id;
	private PaymentMaster payment_typeID;
	private Date payment_date;
	private Student student_id;
	private Course course_id;
	private Batch batch_id;
	private double amount;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public PaymentMaster getPayment_typeID() {
		return payment_typeID;
	}
	public void setPayment_typeID(PaymentMaster payment_typeID) {
		this.payment_typeID = payment_typeID;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public Student getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Student student_id) {
		this.student_id = student_id;
	}
	public Course getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Course course_id) {
		this.course_id = course_id;
	}
	public Batch getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(Batch batch_id) {
		this.batch_id = batch_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}