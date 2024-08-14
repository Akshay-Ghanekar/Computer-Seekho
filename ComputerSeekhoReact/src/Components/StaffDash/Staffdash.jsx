import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import './Staffdash.css'; // Import the CSS file
import Header from './Navbar';
import FollowUpForm from './FollowUpForm';

function Staffdash() {
    const location = useLocation();
    const navigate = useNavigate();
    const { loggedInUser } = location.state || {};
    const [enquiries, setEnquiries] = useState([]);
    const [students, setStudents] = useState([]);
    const [batches, setBatches] = useState([]);
    const [studentsInBatch, setStudentsInBatch] = useState([]);
    const [selectedBatch, setSelectedBatch] = useState('');
    const [error, setError] = useState('');
    const [selectedEnquiry, setSelectedEnquiry] = useState(null);
    
    useEffect(() => {
        if (loggedInUser) {
            const fetchEnquiries = async () => {
                try {
                    const response = await fetch(`http://localhost:8080/api/getEnquiriesByStaffId/${loggedInUser.staff_id}`);
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    const data = await response.json();

                    // Filter out processed enquiries
                    const filteredData = data.filter(enquiry => !enquiry.enquiryProcessedFlag);
                    // Sort enquiries by follow-up date
                    const sortedData = filteredData.sort((a, b) => new Date(a.followUpDate) - new Date(b.followUpDate));

                    setEnquiries(sortedData);
                } catch (error) {
                    console.error('Error fetching enquiries:', error);
                    setError('Failed to load enquiries');
                }
            };

            fetchEnquiries();
        }
    }, [loggedInUser]);

    const handleCallClick = (enquiryId) => {
        navigate(`/update-enquiry/${enquiryId}`);
    };

    const handleAddEnquiryClick = () => {
        navigate('/add-enquiry', { state: { staffId: loggedInUser.staff_id } });// Adjust the route as needed
    };

    const handleRegisterStudentsClick = () => {
        navigate('/register-students',{ state: { staffId: loggedInUser.staff_id } }); // Adjust the route as needed
    };

    const handleGetAllStudents = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/student');
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            console.log(data); // Debugging line
            setStudents(data);
        } catch (error) {
            console.error('Error fetching students:', error);
            setError('Failed to load students');
        }
    };


    const handleGetAllBatches = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/batches'); // Adjust the endpoint if needed
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            setBatches(data);
        } catch (error) {
            console.error('Error fetching batches:', error);
            setError('Failed to load batches');
        }
    };

    const handleGetStudentsInBatch = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/getStudentsByBatch/${selectedBatch}`); // Adjust the endpoint if needed
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            setStudentsInBatch(data);
        } catch (error) {
            console.error('Error fetching students in batch:', error);
            setError('Failed to load students in batch');
        }
    };

    const handleGetAllEnquiries = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/getenq');
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            setEnquiries(data); // Update the enquiries state with all enquiries
        } catch (error) {
            console.error('Error fetching all enquiries:', error);
            setError('Failed to load all enquiries');
        }
    };

    const getDueStatus = (followUpDate) => {
        const today = new Date();
        const followUp = new Date(followUpDate);

        if (followUp < today) {
            return { text: 'Due', color: 'red' };
        } else if (followUp.toDateString() === today.toDateString()) {
            return { text: 'Due', color: 'orange' };
        } else {
            return { text: 'Upcoming', color: 'black' };
        }
    };

    const formatDate = (dateString) => {
        const date = new Date(dateString);
        const day = String(date.getDate()).padStart(2, '0');
        const month = String(date.getMonth() + 1).padStart(2, '0'); // Months are zero-based
        const year = date.getFullYear();
        return `${day}/${month}/${year}`;
    };

    return (
        <><Header/>
        <div className="staffdash-container">
            
            <br /><br /><br />
            <h1>Hello, {loggedInUser ? loggedInUser.staff_name : 'Staff'}!</h1>

            {/* Enquiries Table */}
            <h3> <button className="btn btn-secondary" onClick={handleGetAllEnquiries}>
                Get All Enquiries
            </button></h3>
            <h2>Your FollowUps:</h2>
            {enquiries.length > 0 ? (
                <table className="styled-table">
                    <thead>
                        <tr>
                            <th>Enq. Id</th>
                            <th>Enquirer Name</th>
                            <th>Student Name</th>
                            <th>Phone</th>
                            <th>Follow-up Date</th>
                            <th>Due</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {enquiries.map(enquiry => {
                            const dueStatus = getDueStatus(enquiry.followUpDate);
                            return (
                                <tr key={enquiry.enquiryId}> {/* Ensure unique key prop */}
                                    <td>{enquiry.enquiryId}</td>
                                    <td>{enquiry.enquirerName || 'N/A'}</td>
                                    <td>{enquiry.studentName || 'N/A'}</td>
                                    <td>{enquiry.enquirerMobile || 'N/A'}</td>
                                    {/* <td>{enquiry.courseId ? enquiry.courseId.courseName : 'N/A'}</td> */}
                                    <td>{enquiry.followUpDate ? formatDate(enquiry.followUpDate) : 'N/A'}</td>
                                    <td style={{ color: dueStatus.color }}>{dueStatus.text}</td>
                                    <td>
                                        <button className="btn btn-primary" onClick={() => handleCallClick(enquiry.enquiryId)}>
                                            Call
                                        </button>
                                    </td>
                                </tr>
                            );
                        })}
                    </tbody>


                </table>
            ) : (
                <p>No enquiries found.</p>
            )}

            {/* Additional Features */}
            <div className="button-container">
                <button className="btn btn-secondary" onClick={handleAddEnquiryClick}>
                    Add Enquiry
                </button>
                <button className="btn btn-secondary" onClick={handleRegisterStudentsClick}>
                    Register Students
                </button>
                <button className="btn btn-secondary" onClick={handleGetAllStudents}>
                    Get All Students
                </button>

            </div>

            {error && <p className="text-danger">{error}</p>}

            {/* Separate tables for additional features */}
            {students.length > 0 && (
                <div>
                    <h2>All Students:</h2>
                    <table className="styled-table">
                        <thead>
                            <tr>
                                <th>Student ID</th>
                                <th>Name</th>
                                <th>Mobile</th>
                                <th>Address</th>
                            </tr>
                        </thead>
                        <tbody>
                            {students.map(student => (
                                <tr key={student.student_id}>
                                    <td>{student.student_id}</td>
                                    <td>{student.student_name}</td>
                                    <td>{student.student_mobile}</td>
                                    <td>{student.student_address}</td>
                                </tr>
                            ))}
                        </tbody>



                    </table>
                </div>
            )}

            {batches.length > 0 && (
                <div>
                    <h2>All Batches:</h2>
                    <table className="styled-table">
                        <thead>
                            <tr>
                                <th>Batch ID</th>
                                <th>Batch Name</th>
                                <th>Course</th>
                            </tr>
                        </thead>
                        <tbody>
                            {batches.map(batch => (
                                <tr key={batch.batchId}> {/* Add unique key prop here */}
                                    <td>{batch.batchId}</td>
                                    <td>{batch.batchName}</td>
                                    <td>{batch.courseId ? batch.courseId.courseName : 'N/A'}</td>
                                </tr>
                            ))}
                        </tbody>

                    </table>
                </div>
            )}

            {studentsInBatch.length > 0 && (
                <div>
                    <h2>Students in Selected Batch:</h2>
                    <table className="styled-table">
                        <thead>
                            <tr>
                                <th>Student ID</th>
                                <th>Name</th>
                                <th>Mobile</th>
                                <th>Address</th>
                            </tr>
                        </thead>
                        <tbody>
                            {studentsInBatch.map(student => (
                                <tr key={student.studentId}> {/* Add unique key prop here */}
                                    <td>{student.studentId}</td>
                                    <td>{student.studentName}</td>
                                    <td>{student.studentMobile}</td>
                                    <td>{student.studentAddress}</td>
                                </tr>
                            ))}
                        </tbody>

                    </table>
                </div>
            )}
        </div>
        </>
    );
}

export default Staffdash;
