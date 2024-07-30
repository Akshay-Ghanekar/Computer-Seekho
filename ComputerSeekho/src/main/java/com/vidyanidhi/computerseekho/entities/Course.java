package com.vidyanidhi.computerseekho.entities;


import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "CourseMaster")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_description")
    private String courseDescription;

    @Column(name = "course_duration")
    private int courseDuration;

    @Column(name = "course_fees")
    private int courseFees;

    @Column(name = "course_fees_from")
    @Temporal(TemporalType.DATE)
    private Date courseFeesFrom;

    @Column(name = "course_fees_to")
    @Temporal(TemporalType.DATE)
    private Date courseFeesTo;

    @Column(name = "course_syllabus")
    private String courseSyllabus;

    @Column(name = "age_grp_type")
    private String ageGrpType;

    @Column(name = "course_is_active")
    private boolean courseIsActive;

    @Column(name = "cover_photo")
    private String coverPhoto;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public int getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(int courseFees) {
		this.courseFees = courseFees;
	}

	public Date getCourseFeesFrom() {
		return courseFeesFrom;
	}

	public void setCourseFeesFrom(Date courseFeesFrom) {
		this.courseFeesFrom = courseFeesFrom;
	}

	public Date getCourseFeesTo() {
		return courseFeesTo;
	}

	public void setCourseFeesTo(Date courseFeesTo) {
		this.courseFeesTo = courseFeesTo;
	}

	public String getCourseSyllabus() {
		return courseSyllabus;
	}

	public void setCourseSyllabus(String courseSyllabus) {
		this.courseSyllabus = courseSyllabus;
	}

	public String getAgeGrpType() {
		return ageGrpType;
	}

	public void setAgeGrpType(String ageGrpType) {
		this.ageGrpType = ageGrpType;
	}

	public boolean isCourseIsActive() {
		return courseIsActive;
	}

	public void setCourseIsActive(boolean courseIsActive) {
		this.courseIsActive = courseIsActive;
	}

	public String getCoverPhoto() {
		return coverPhoto;
	}

	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

//    @ManyToOne
//    @JoinColumn(name = "video_id")
//    private VideoMaster videoMaster;

   
}
