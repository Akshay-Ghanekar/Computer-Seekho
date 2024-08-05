package com.vidyanidhi.computerseekho.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PaymentMaster")
public class PaymentMaster {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_typeID;
	
	@Column(name="Payment_Type_Desc",nullable=false)
	private String Payment_Type_Desc;
	
	public int getPayment_typeID() {
		return payment_typeID;
	}
	public void setPayment_typeID(int payment_typeID) {
		this.payment_typeID = payment_typeID;
	}
	public String getPayment_Type_Desc() {
		return Payment_Type_Desc;
	}
	public void setPayment_Type_Desc(String payment_Type_Desc) {
		Payment_Type_Desc = payment_Type_Desc;
	}

}
