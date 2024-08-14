import React, { useState } from 'react';
import { Navigate } from 'react-router-dom';
import './Login.css';  // Make sure this CSS file is imported

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [redirectPath, setRedirectPath] = useState('');
    const [loggedInUser, setLoggedInUser] = useState(null);
    const [errorMessage, setErrorMessage] = useState('');  // Add error state

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await fetch(`http://localhost:8080/api/stafflog/${username}`);
            const staffData = await response.json();
            console.log(staffData);

            if (Array.isArray(staffData)) {
                const validUser = staffData.find(
                    staffEntry => staffEntry.staff_password === password
                );

                if (validUser) {
                    setLoggedInUser(validUser);
                    setRedirectPath("/staffdash");
                } else {
                    setErrorMessage('Invalid credentials');
                }
            } else if (typeof staffData === 'object') {
                if (staffData.staff_password === password) {
                    setLoggedInUser(staffData);
                    setRedirectPath(staffData.staff_role === "admin" ? "/admindash" : "/staffdash");
                } else {
                    setErrorMessage('Invalid credentials');
                }
            } else {
                setErrorMessage('Invalid response format');
            }
        } catch (error) {
            setErrorMessage('Invalid Credentials');
        }
    };

    if (redirectPath) {
        return <Navigate to={redirectPath} state={{ loggedInUser }} />;
    }

    return (
        <div className="admin-login-container">
            <div className="card shadow">
                <div className="card-body">
                    <h2 className="card-title">Login</h2>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="username" className="form-label">Username:</label>
                            <input
                                type="text"
                                className="form-control"
                                id="username"
                                placeholder="Username"
                                value={username}
                                onChange={handleUsernameChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="password" className="form-label">Password:</label>
                            <input
                                type="password"
                                className="form-control"
                                id="password"
                                placeholder="Enter password"
                                value={password}
                                onChange={handlePasswordChange}
                                required
                            />
                        </div>
                        {errorMessage && <p className="text-danger">{errorMessage}</p>} {/* Display error message */}
                        <button type="submit" className="btn btn-primary">Login</button>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default Login;