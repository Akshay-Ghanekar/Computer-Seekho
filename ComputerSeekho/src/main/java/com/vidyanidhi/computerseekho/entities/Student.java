package com.vidyanidhi.computerseekho.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentMaster")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;

    @Column(name = "student_name")
    private String student_name;

    @Column(name = "student_address")
    private String student_address;

    @Column(name = "student_mobile")
    private int student_mobile;

    @Column(name = "student_email")
    private String student_email;

    @Column(name = "student_is_active")
    private boolean student_is_active;

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public int getStudent_mobile() {
		return student_mobile;
	}

	public void setStudent_mobile(int student_mobile) {
		this.student_mobile = student_mobile;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public boolean isStudent_is_active() {
		return student_is_active;
	}

	public void setStudent_is_active(boolean student_is_active) {
		this.student_is_active = student_is_active;
	}
	
}
