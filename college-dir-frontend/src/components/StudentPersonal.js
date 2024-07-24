import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, Link } from 'react-router-dom';
import './StudentPersonal.css';

function StudentPersonal() {
    const { username } = useParams();
    const [profile, setProfile] = useState(null);

    useEffect(() => {
        if (username) {
            axios.get(`http://localhost:8081/api/users/${username}`)
                .then(response => setProfile(response.data))
                .catch(error => console.error('Error fetching profile data:', error));
        }
    }, [username]);

    if (!profile) return <p>Loading...</p>;

    return (
        <div className="profile-card">
            <h2 className="profile-title">Personal Profile</h2>
            <div className="profile-header">
                <img src="/default-profile.jpg" alt="Profile.jpg" className="profile-photo" />
                <div className="profile-details">
                    <h3>{profile.name}</h3>
                </div>
            </div>
            <div className="profile-table">
                <table>
                    <tbody>
                        <tr>
                            <th>Email:</th>
                            <td>{profile.email}</td>
                        </tr>
                        <tr>
                            <th>Phone:</th>
                            <td>{profile.phone}</td>
                        </tr>
                        <tr>
                            <th>Username:</th>
                            <td>{profile.username}</td>
                        </tr>
                        <tr>
                            <th>Role:</th>
                            <td>{profile.role}</td>
                        </tr>
                        <tr>
                            <th>ID:</th>
                            <td>{profile.id}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div className="button-container">
                <Link to="/all-students">
                    <button className="view-all-users-button">View All Users</button>
                </Link>
            </div>
        </div>
    );
}

export default StudentPersonal;
