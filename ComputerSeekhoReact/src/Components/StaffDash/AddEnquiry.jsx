// AddEnquiry.jsx
import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import './AddEnquiry.css';

function AddEnquiry() {
    const location = useLocation();
    const navigate = useNavigate();
    const { staffId } = location.state || {}; // Get staffId from location.state
    const [enquiry, setEnquiry] = useState({
        enquirerName: '',
        enquirerAddress: '',
        enquirerMobile: '',
        enquirerAlternateMobile: '',
        enquirerEmailId: '',
        enquirerQuery: '',
        enquiryProcessedFlag: false,
        studentName: '',
        staffId: staffId ? { staff_id: staffId } : {} // Use the staffId if available
    });
    const [error, setError] = useState('');

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setEnquiry(prev => ({
            ...prev,
            [name]: type === 'checkbox' ? checked : value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const currentDate = new Date().toISOString().split('T')[0];
            const enquiryData = { ...enquiry, enquiryDate: currentDate };
    
            console.log('Submitting Enquiry Data:', enquiryData);
    
            const response = await fetch('http://localhost:8080/api/new_enquiry', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(enquiryData),
            });
    
            if (!response.ok) throw new Error('Failed to submit enquiry');
    
            // Navigate to Staffdash and pass loggedInUser state
            navigate('/staffdash', { state: { loggedInUser: { staff_id: staffId } } });
        } catch (error) {
            console.error('Error submitting enquiry:', error);
            setError('Error submitting enquiry. Please check the console for details.');
        }
    };
    

    return (
        <div className="add-enquiry-container"><br />
            <h1>Add Enquiry</h1>
            {error && <p className="text-danger">{error}</p>}
            <form onSubmit={handleSubmit}>
                <label>
                    Enquirer Name:
                    <input type="text" name="enquirerName" value={enquiry.enquirerName} onChange={handleChange} required />
                </label>
                <label>
                    Student Name:
                    <input type="text" name="studentName" value={enquiry.studentName} onChange={handleChange} required />
                </label>
                <br />
                <label>
                    Address:
                    <input type="text" name="enquirerAddress" value={enquiry.enquirerAddress} onChange={handleChange} required />
                </label>
                <br />
                <label>
                    Mobile:
                    <input type="text" name="enquirerMobile" value={enquiry.enquirerMobile} onChange={handleChange} required />
                </label>
                <br />
                <label>
                    Alternate Mobile:
                    <input type="text" name="enquirerAlternateMobile" value={enquiry.enquirerAlternateMobile} onChange={handleChange} />
                </label>
                <br />
                <label>
                    Email:
                    <input type="email" name="enquirerEmailId" value={enquiry.enquirerEmailId} onChange={handleChange} required />
                </label>
                <br />
                <label>
                    Query:
                    <textarea name="enquirerQuery" value={enquiry.enquirerQuery} onChange={handleChange} required></textarea>
                </label>
                <br />
                <label>
                    Enquiry Completed:
                    <input type="checkbox" name="enquiryProcessedFlag" checked={enquiry.enquiryProcessedFlag} onChange={handleChange} />
                </label>
                <br />
                <button type="submit">Save</button>
            </form>
        </div>
    );
}

export default AddEnquiry;
