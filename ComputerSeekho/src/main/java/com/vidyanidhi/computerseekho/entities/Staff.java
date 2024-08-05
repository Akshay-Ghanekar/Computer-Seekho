package com.vidyanidhi.computerseekho.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staff_id;

    @Column(name = "staff_name")
    private String staff_name;

    @Column(name = "staff_role")
    private String staff_role;

    @Column(name = "staff_mobile")
    private int staff_mobile;

    @Column(name = "staff_email")
    private String staff_email;

    @OneToMany(mappedBy = "staffid", cascade = CascadeType.ALL)
    private Set<Followup> followups;

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_role() {
		return staff_role;
	}

	public void setStaff_role(String staff_role) {
		this.staff_role = staff_role;
	}

	public int getStaff_mobile() {
		return staff_mobile;
	}

	public void setStaff_mobile(int staff_mobile) {
		this.staff_mobile = staff_mobile;
	}

	public String getStaff_email() {
		return staff_email;
	}

	public void setStaff_email(String staff_email) {
		this.staff_email = staff_email;
	}

	public Set<Followup> getFollowups() {
		return followups;
	}

	public void setFollowups(Set<Followup> followups) {
		this.followups = followups;
	}

    
}
