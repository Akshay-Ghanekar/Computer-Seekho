import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

function Payment() {
    const { batchId, enquiryId } = useParams();
    const [fees, setFees] = useState(0);
    const [paymentTypes, setPaymentTypes] = useState([]);
    const [selectedPaymentType, setSelectedPaymentType] = useState('');
    const [transactionId, setTransactionId] = useState('');
    const [studentDetails, setStudentDetails] = useState(null);

    useEffect(() => {
        // Fetch fees and student details based on batchId and enquiryId
        const fetchDetails = async () => {
            try {
                const batchResponse = await fetch(`http://localhost:8080/api/batch/${batchId}`);
                if (!batchResponse.ok) {
                    throw new Error('Network response was not ok');
                }
                const batch = await batchResponse.json();
                setFees(batch.fees); // Ensure the correct field is being used

                // Fetch student details
                const studentResponse = await fetch(`http://localhost:8080/api/getStudentByEnquiryId/${enquiryId}`);
                if (!studentResponse.ok) {
                    throw new Error('Network response was not ok');
                }
                const student = await studentResponse.json();
                setStudentDetails(student);
            } catch (error) {
                console.error('Error fetching details:', error);
            }
        };

        fetchDetails();

        // Fetch payment types
        const fetchPaymentTypes = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/paymentType');
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                const types = await response.json();
                setPaymentTypes(types);
            } catch (error) {
                console.error('Error fetching payment types:', error);
            }
        };

        fetchPaymentTypes();
    }, [batchId, enquiryId]);

    const handlePaymentTypeChange = (e) => {
        setSelectedPaymentType(e.target.value);
    };8

    const handleTransactionIdChange = (e) => {
        setTransactionId(e.target.value);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const payload = {
            student: studentDetails,
            batch: batchId,
            amount: fees,
            paymentType: selectedPaymentType,
            transactionId: selectedPaymentType === 'Cash' ? '' : transactionId,
        };

        try {
            const response = await fetch('http://localhost:8080/api/payments', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(payload),
            });

            if (response.ok) {
                console.log('Payment submitted successfully');
                // Handle post-submission logic here
            } else {
                console.error('Error submitting payment');
            }
        } catch (error) {
            console.error('Error saving payment:', error);
        }
    };

    return (
        <div className="payment-form"><br /><br /><br /><br /><br />
            <h2>Payment Form</h2>
            {studentDetails && (
                <div>
                    <p><strong>Student Name:</strong> {studentDetails.student_name}</p>
                    <p><strong>Batch:</strong> {studentDetails.batch.batch_name}</p>
                </div>
            )}
            <p>Fees to be paid: ${fees}</p>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="paymentType">Payment Type:</label>
                    <select id="paymentType" value={selectedPaymentType} onChange={handlePaymentTypeChange}>
                        <option value="" disabled>Select Payment Type</option>
                        {paymentTypes.map(type => (
                            <option key={type.payment_type_id} value={type.payment_type_desc}>
                                {type.payment_type_desc}
                            </option>
                        ))}
                    </select>
                </div>
                {selectedPaymentType === 'Net Banking' || selectedPaymentType === 'Credit Card' ? (
                    <div>
                        <label htmlFor="transactionId">Transaction ID:</label>
                        <input
                            type="text"
                            id="transactionId"
                            value={transactionId}
                            onChange={handleTransactionIdChange}
                        />
                    </div>
                ) : null}
                <button type="submit">Submit Payment</button>
            </form>
        </div>
    );
}

export default Payment;
