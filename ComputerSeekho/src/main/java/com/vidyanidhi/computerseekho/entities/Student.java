package com.vidyanidhi.computerseekho.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	
	private String  student_name ;
	
	private String student_address;
	
	private String student_gender;
	
	private String photo_url;
	
	private Date student_dob;
	
	private String  student_qualification;
	
	private String  student_mobile;
	
	//private Course course_fee;

	//private Batch batch_id;
	
	//private int course_id;
	
	private String student_password;
	
	private String student_username;

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

	public String getStudent_gender() {
		return student_gender;
	}

	public void setStudent_gender(String student_gender) {
		this.student_gender = student_gender;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public Date getStudent_dob() {
		return student_dob;
	}

	public void setStudent_dob(Date student_dob) {
		this.student_dob = student_dob;
	}

	public String getStudent_qualification() {
		return student_qualification;
	}

	public void setStudent_qualification(String student_qualification) {
		this.student_qualification = student_qualification;
	}

	public String getStudent_mobile() {
		return student_mobile;
	}

	public void setStudent_mobile(String student_mobile) {
		this.student_mobile = student_mobile;
	}

	public String getStudent_password() {
		return student_password;
	}

	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}

	public String getStudent_username() {
		return student_username;
	}

	public void setStudent_username(String student_username) {
		this.student_username = student_username;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_address="
				+ student_address + ", student_gender=" + student_gender + ", photo_url=" + photo_url + ", student_dob="
				+ student_dob + ", student_qualification=" + student_qualification + ", student_mobile="
				+ student_mobile + ", student_password=" + student_password + ", student_username=" + student_username
				+ "]";
	}
	
	
}
