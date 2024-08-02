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
    
}
