import React from 'react';
import { Routes, Route, useLocation } from 'react-router-dom'; // Import useLocation
import Navbar from './Components/Navbar/Navbar';
import Hero from './Components/Hero/Hero';
import Courses from './Components/Courses/Courses';
import Aboutus from './Components/Aboutus/Aboutus';
import Info from './Components/Info/Info';
import Campus from './Components/Campus/Campus';
import Contact from './Components/Contact/Contact';
import Login from './Components/Login/Login';
import Admindash from './Components/AdminDash/Admindash';
import Staffdash from './Components/StaffDash/Staffdash';
import UpdateEnquiry from './Components/UpdateEnquiry/UpdateEnquiry';
import RegisterStudents from './Components/StaffDash/RegisterStudents';
import AddEnquiry from './Components/StaffDash/AddEnquiry';
import Payments from './Components/StaffDash/Payments';
import Manipulate from './Components/AdminDash/Manipulate/Manipulate';
import Staff from './Components/AdminDash/Manipulate/Staff/Staff'
import CreateStaff from './Components/AdminDash/Manipulate/Staff/CreateStaff'
import CreateCourse from './Components/AdminDash/Manipulate/Courses/CreateCourse';
import CreateBatch from './Components/AdminDash/Manipulate/Batches/CreateBatch';
import EditBatch from './Components/AdminDash/Manipulate/Batches/EditBatch';
import Placements from './Components/Placements/Placements';
import Footer from './Components/Footer/Footer';

const App = () => {
  const location = useLocation();
  const showNavbar = !['/admindash', '/staffdash','/manipulate' , '/createstaff', '/create-course'  , '/create-batch' , '/edit-batch/${batchId}','/update-enquiry/${enquiryId}'].includes(location.pathname);

  return (
    <div>
      {showNavbar && <Navbar />}
      <Routes>
        <Route path="/" element={<><Hero /><div className='container'>
          <Aboutus subtitle='Our Courses' title='What we offer' />
          <Courses />
          <Info />
          <Aboutus subtitle='Gallery' title='Campus Photo' />
          <Campus />
          <Placements/>
          <Aboutus subtitle='' title='' />
          <div>
          <Aboutus subtitle='contact' title='Get in Touch' /></div>
          <section id="contact">
        <Contact />
        </section>
        </div></>} />

        <Route path="/login" element={<Login />} />
        <Route path="/admindash" element={<Admindash />} />
        <Route path="/staffdash" element={<Staffdash />} />
        <Route path="/update-enquiry/:enquiryId" element={<UpdateEnquiry />} />
        <Route path="/add-enquiry" element={<AddEnquiry />} />
        <Route path="/register-students" element={<RegisterStudents />} />
        <Route path="/payment/:enquiry_id/:selectedBatchId" element={<Payments />} />
        <Route path="/manipulate" element={<Manipulate/>}/>
        <Route path="/courses" element={<Courses />} />
        <Route path="/placements" element={<Placements />} />
        <Route path="/staffcrud" element={<Staff />} />
        <Route path="/createstaff" element={<CreateStaff />} />
        <Route path="/create-course" element={<CreateCourse />} />
        <Route path="/create-batch" element={<CreateBatch />} />
        <Route path="/edit-batch/${batchId}" element={<EditBatch />} />
      </Routes>
      <Footer />
    </div>
  );
}

export default App;