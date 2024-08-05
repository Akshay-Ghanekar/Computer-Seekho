package com.vidyanidhi.computerseekho.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ClosureReasonMaster {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Closure_ReasonID;
	
	@Column(name="Closure_Reason_desc",nullable=false)
	private String Closure_Reason_desc;

	public int getClosure_ReasonID() {
		return Closure_ReasonID;
	}

	public void setClosure_ReasonID(int closure_ReasonID) {
		Closure_ReasonID = closure_ReasonID;
	}

	public String getClosure_Reason_desc() {
		return Closure_Reason_desc;
	}

	public void setClosure_Reason_desc(String closure_Reason_desc) {
		Closure_Reason_desc = closure_Reason_desc;
	}
}
