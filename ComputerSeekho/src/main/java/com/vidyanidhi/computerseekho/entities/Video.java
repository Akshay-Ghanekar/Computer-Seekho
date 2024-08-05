package com.vidyanidhi.computerseekho.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int video_id;
	private String video_description;
	private String video_url;
	private boolean video_is_active;
	private Date start_date;
	private Date end_date;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
 	private Course course_id;
	
	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getVideo_id() {
		return video_id;
	}

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(int video_id, String video_description, String video_url, boolean video_is_active) {
		super();
		this.video_id = video_id;
		this.video_description = video_description;
		this.video_url = video_url;
		this.video_is_active = video_is_active;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

	public String getVideo_description() {
		return video_description;
	}

	public void setVideo_description(String video_description) {
		this.video_description = video_description;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public boolean isVideo_is_active() {
		return video_is_active;
	}

	public void setVideo_is_active(boolean video_is_active) {
		this.video_is_active = video_is_active;
	}

	@Override
	public String toString() {
		return "Videos [video_id=" + video_id + ", video_description=" + video_description + ", video_url=" + video_url
				+ ", video_is_active=" + video_is_active + ", start_date=" + start_date + ", end_date=" + end_date
				+ "]";
	}

}
