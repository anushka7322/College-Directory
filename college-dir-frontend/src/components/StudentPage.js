import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './StudentPage.css'; // Create this CSS file for styling

function StudentTable() {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        // Fetch users data from the API
        axios.get('http://localhost:8081/api/students') // Adjust the endpoint as needed
            .then(response => setUsers(response.data))
            .catch(error => console.error('Error fetching user data:', error));
    }, []);

    return (
        <div className="user-table-container">
            <h2>Students List</h2>
            <table className="user-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map(user => (
                        <tr key={user.user_id.id}> {/* Adjust key to match the nested data structure */}
                            <td>{user.user_id.id}</td>
                            <td>{user.user_id.username}</td>
                            <td>{user.user_id.name}</td>
                            <td>{user.user_id.email}</td>
                            <td>{user.user_id.phone}</td>
                            <td>{user.user_id.role}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default StudentTable;
