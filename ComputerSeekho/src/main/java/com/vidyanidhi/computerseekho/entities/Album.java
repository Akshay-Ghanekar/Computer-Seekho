package com.vidyanidhi.computerseekho.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "AlbumMaster")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int album_id;

	@Column(name = "album_name", nullable = false)
	private String album_name;

	@Column(name = "album_description", nullable = false)
	private String album_description;

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date start_date;

	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	private Date end_date;

	@Column(name = "album_is_active")
	private boolean album_is_active;

	public int getAlbumId() {
		return album_id;
	}

	public void setAlbumId(int album_id) {
		this.album_id = album_id;
	}

	public String getAlbumName() {
		return album_name;
	}

	public void setAlbumName(String album_name) {
		this.album_name = album_name;
	}

	public String getAlbumDescription() {
		return album_description;
	}

	public void setAlbumDescription(String album_description) {
		this.album_description = album_description;
	}

	public Date getStartDate() {
		return start_date;
	}

	public void setStartDate(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEndDate() {
		return end_date;
	}

	public void setEndDate(Date end_date) {
		this.end_date = end_date;
	}

	public boolean getAlbumIsActive() {
		return album_is_active;

	}

	public void setAlbumIsActive(boolean album_is_active) {
		this.album_is_active = album_is_active;
	}

	public Object isAlbum_is_active() {
		// TODO Auto-generated method stub
		return null;
	}
}
