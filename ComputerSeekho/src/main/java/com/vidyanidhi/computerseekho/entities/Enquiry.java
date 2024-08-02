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
@Table(name = "Enquiry")
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
    
//    @ManyToOne
//    @JoinColumn(name="closure_reason_id" , referencedColumnName="id")
//    private ClosureReasonMaster Closurereasonid;
    
<<<<<<< HEAD
=======
    @Column(name="closure_reason")
    private String closurereason;
    
    @Column(name="enquiry_processed_flag")
    private boolean enquiryprocessedflag;
    
    @ManyToOne
    @JoinColumn(name="course_id" , referencedColumnName="id")
    private Course courseid;

    @ManyToOne
    @JoinColumn(name="staff_id" , referencedColumnName="id")
    private Staff staffid;
    
    @Column(name="student_name")
    private String studentname;
    
    @Column(name="enquiry_counter")
    private int enquirycounter;
    
    @Column(name = "followup_date")
    @Temporal(TemporalType.DATE)
    private Date followupdate;

	public int getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getEnquirerName() {
		return enquirerName;
	}

	public void setEnquirerName(String enquirerName) {
		this.enquirerName = enquirerName;
	}

	public String getEnquireraddress() {
		return enquireraddress;
	}

	public void setEnquireraddress(String enquireraddress) {
		this.enquireraddress = enquireraddress;
	}

	public int getEnquirermobile() {
		return enquirermobile;
	}

	public void setEnquirermobile(int enquirermobile) {
		this.enquirermobile = enquirermobile;
	}

	public int getEnquireralternatemobile() {
		return enquireralternatemobile;
	}

	public void setEnquireralternatemobile(int enquireralternatemobile) {
		this.enquireralternatemobile = enquireralternatemobile;
	}

	public String getEnquireremailid() {
		return enquireremailid;
	}

	public void setEnquireremailid(String enquireremailid) {
		this.enquireremailid = enquireremailid;
	}

	public Date getEnquirydate() {
		return enquirydate;
	}

	public void setEnquirydate(Date enquirydate) {
		this.enquirydate = enquirydate;
	}

	public String getEnquirerquery() {
		return enquirerquery;
	}

	public void setEnquirerquery(String enquirerquery) {
		this.enquirerquery = enquirerquery;
	}

	public ClosureReasonMaster getClosurereasonid() {
		return Closurereasonid;
	}

	public void setClosurereasonid(ClosureReasonMaster closurereasonid) {
		Closurereasonid = closurereasonid;
	}

	public String getClosurereason() {
		return closurereason;
	}

	public void setClosurereason(String closurereason) {
		this.closurereason = closurereason;
	}

	public boolean isEnquiryprocessedflag() {
		return enquiryprocessedflag;
	}

	public void setEnquiryprocessedflag(boolean enquiryprocessedflag) {
		this.enquiryprocessedflag = enquiryprocessedflag;
	}

	public Course getCourseid() {
		return courseid;
	}

	public void setCourseid(Course courseid) {
		this.courseid = courseid;
	}

	public Staff getStaffid() {
		return staffid;
	}

	public void setStaffid(Staff staffid) {
		this.staffid = staffid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public int getEnquirycounter() {
		return enquirycounter;
	}

	public void setEnquirycounter(int enquirycounter) {
		this.enquirycounter = enquirycounter;
	}

	public Date getFollowupdate() {
		return followupdate;
	}

	public void setFollowupdate(Date followupdate) {
		this.followupdate = followupdate;
	}
	
>>>>>>> branch 'subbranch' of https://github.com/swapnilD31/ComputerSeekho.git
}
