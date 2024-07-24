import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './FacultyPage.css'; // Create this CSS file for styling

function FacultyTable() {
    const [faculty, setFaculty] = useState([]);

    useEffect(() => {
        // Fetch faculty data from the API
        axios.get('http://localhost:8081/api/faculty')
            .then(response => setFaculty(response.data))
            .catch(error => console.error('Error fetching faculty data:', error));
    }, []);

    return (
        <div className="faculty-table-container">
            <h2>Faculty List</h2>
            <table className="faculty-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Role</th>
                        <th>Photo</th>
                        <th>Department</th>
                        <th>Office Hours</th>
                    </tr>
                </thead>
                <tbody>
                    {faculty.map(facultyMember => (
                        <tr key={facultyMember.user.id}> {/* Adjust key to match the nested data structure */}
                            <td>{facultyMember.user.id}</td>
                            <td>{facultyMember.user.username}</td>
                            <td>{facultyMember.user.name}</td>
                            <td>{facultyMember.user.email}</td>
                            <td>{facultyMember.user.phone}</td>
                            <td>{facultyMember.user.role}</td>
                            <td><img src={`path/to/images/${facultyMember.photo}`} alt="Profile" className="faculty-photo" /></td> {/* Adjust image path as needed */}
                            <td>{facultyMember.department.name}</td>
                            <td>{facultyMember.officeHours}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default FacultyTable;
