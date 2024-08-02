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
public class Enquiry 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enquiryId;

    @Column(name = "enquirer_name", nullable = false)
    private String enquirerName;

    @Column(name = "enquirer_address")
    private String enquireraddress;

    @Column(name = "enquirer_mobile")
    private int enquirermobile;
    
    @Column(name = "enquirer_alternate_mobile")
    private int enquireralternatemobile;
    
    @Column(name = "enquirer_emailid")
    private String enquireremailid;

    @Column(name = "enquiry_date")
    @Temporal(TemporalType.DATE)
    private Date enquirydate;
    
    @Column(name = "enquirer_query")
    private String enquirerquery;
    
    @ManyToOne
    @JoinColumn(name="closure_reason_id" , referencedColumnName="id")
    private ClosureReasonMaster Closurereasonid;
    
    
    
    
    
    
    
    

    @Column(name = "course_fees_to")
    @Temporal(TemporalType.DATE)
    private Date courseFeesTo;
    
    //ClosureReasonID
    
    @Column(name = "closure_reason")
    private String closurereason;

    @Column(name = "enquiry_processed_flag")
    private boolean enquiryprocessedflag;

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

}
