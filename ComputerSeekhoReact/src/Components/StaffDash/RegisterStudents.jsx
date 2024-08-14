import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import './RegisterStudents.css'; // Import the CSS file

function RegisterStudents() {
  const navigate = useNavigate();
  const [searchInput, setSearchInput] = useState({ id: '', name: '', mobile: '' });
  const [selectedEnquiry, setSelectedEnquiry] = useState(null);
  const [courses, setCourses] = useState([]);
  const [batches, setBatches] = useState([]);
  const [student, setStudent] = useState({
    student_name: '',
    student_address: '',
    student_gender: '',
    photo_url: '',
    student_dob: '',
    student_qualification: '',
    student_mobile: '',
    course: '',
    batch: ''
  });

  useEffect(() => {
    const fetchCourses = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/courses');
        const data = await response.json();
        setCourses(data);
      } catch (error) {
        console.error('Error fetching courses:', error);
      }
    };

    fetchCourses();
  }, []);

  useEffect(() => {
    if (student.course) {
      const fetchBatches = async () => {
        try {
          const response = await fetch(`http://localhost:8080/api/getBatchByCourseId/${student.course}`);
          const data = await response.json();
          setBatches(data);
        } catch (error) {
          console.error('Error fetching batches:', error);
        }
      };

      fetchBatches();
    }
  }, [student.course]);

  const handleSearchSubmit = async (type) => {
    try {
      let response;
      if (type === 'id') {
        response = await fetch(`http://localhost:8080/api/getById/${searchInput.id}`);
      } else if (type === 'name') {
        response = await fetch(`http://localhost:8080/api/getByName/${searchInput.name}`);
      } else if (type === 'mobile') {
        response = await fetch(`http://localhost:8080/api/getByMobile/${searchInput.mobile}`);
      }
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      if (data) {
        setSelectedEnquiry(data);
        setStudent({
          ...student,
          student_name: data.enquirerName,
          student_mobile: data.enquirerMobile,
          student_address: data.enquirerAddress,
          // Add other fields as necessary
        });
      } else {
        setSelectedEnquiry(null);
        alert('No enquiry found');
      }
    } catch (error) {
      console.error('Error fetching enquiry:', error);
    }
  };

  const handleSubmit = async () => {
    const payload = {
      student_name: student.student_name,
      student_address: student.student_address,
      student_gender: student.student_gender,
      photo_url: student.photo_url,
      student_dob: student.student_dob,
      student_qualification: student.student_qualification,
      student_mobile: student.student_mobile,
      course: {
        course_id: parseInt(student.course)
      },
      batch: {
        batch_id: parseInt(student.batch)
      }
    };

    console.log('Submitting student:', payload); // Log the payload

    try {
      const response = await fetch('http://localhost:8080/api/students', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
      });

      if (response.ok) {
        // Fetch batch fees and other required information to navigate to payment page
        const batchResponse = await fetch(`http://localhost:8080/api/batch/${student.batch}`);
        const batchData = await batchResponse.json();

        if (batchData) {
          console.log("Student registered successfully");
          setTimeout(() => {
            navigate(`/staffdash`);
            //navigate(`/payment/${selectedEnquiry.enquiryId}/${student.batch}`);
          }, 1000);
        } else {
          console.error("Error fetching batch data");
        }
      } else {
        console.error("Error registering student");
      }
    } catch (error) {
      console.error('Error saving student:', error);
    }
  };

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  return (
    <div className="register-students-container"><br /><br /><br /><br />
      <h1>Register Students</h1>
      <div className="search-container">
        <div className="search-item">
          <input
            type="text"
            placeholder="Search by Enquiry ID"
            value={searchInput.id}
            onChange={(e) => setSearchInput({ ...searchInput, id: e.target.value })}
          />
          <button onClick={() => handleSearchSubmit('id')}>Search by ID</button>
        </div>
        <div className="search-item">
          <input
            type="text"
            placeholder="Search by Name"
            value={searchInput.name}
            onChange={(e) => setSearchInput({ ...searchInput, name: e.target.value })}
          />
          <button onClick={() => handleSearchSubmit('name')}>Search by Name</button>
        </div>
        <div className="search-item">
          <input
            type="text"
            placeholder="Search by Mobile"
            value={searchInput.mobile}
            onChange={(e) => setSearchInput({ ...searchInput, mobile: e.target.value })}
          />
          <button onClick={() => handleSearchSubmit('mobile')}>Search by Mobile</button>
        </div>
      </div>
      {selectedEnquiry && (
        <div className="enquiry-details">
          <h2>Enquiry Details</h2>
          <p>Name: {selectedEnquiry.enquirerName}</p>
          <p>Mobile: {selectedEnquiry.enquirerMobile}</p>
          {/* Add other fields as necessary */}
        </div>
      )}
      <h2>Student Registration Form</h2>
      <form className="registration-form">
        <input
          type="text"
          name="student_name"
          placeholder="Student Name"
          value={student.student_name}
          onChange={handleChange}
        />
        <input
          type="text"
          name="student_address"
          placeholder="Student Address"
          value={student.student_address}
          onChange={handleChange}
        />
        {/* <input
          type="text"
          name="student_gender"
          placeholder="Student Gender"
          value={student.student_gender}
          onChange={handleChange}
        /> */}
        <select
  name="student_gender"
  value={student.student_gender}
  onChange={handleChange}
>
  <option value="" disabled>Select Gender</option>
  <option value="Male">Male</option>
  <option value="Female">Female</option>
  <option value="Other">Other</option>
</select>

        <input
          type="text"
          name="photo_url"
          placeholder="Photo URL"
          value={student.photo_url}
          onChange={handleChange}
        />
        <input
          type="date"
          name="student_dob"
          placeholder="Student DOB"
          value={student.student_dob}
          onChange={handleChange}
        />
        <input
          type="text"
          name="student_qualification"
          placeholder="Student Qualification"
          value={student.student_qualification}
          onChange={handleChange}
        />
        <input
          type="text"
          name="student_mobile"
          placeholder="Student Mobile"
          value={student.student_mobile}
          onChange={handleChange}
        />
        <select name="course" value={student.course} onChange={handleChange}>
          <option value="">Select Course</option>
          {courses.map((course) => (
            <option key={course.course_id} value={course.course_id}>
              {course.course_name}
            </option>
          ))}
        </select>
        <select name="batch" value={student.batch} onChange={handleChange}>
          <option value="">Select Batch</option>
          {batches.map((batch) => (
            <option key={batch.batch_id} value={batch.batch_id}>
              {batch.batch_name}
            </option>
          ))}
        </select>
        <button type="button" onClick={handleSubmit}>Save</button>
      </form>
    </div>
  );
}

export default RegisterStudents;
