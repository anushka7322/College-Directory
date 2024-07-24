package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "facultyprofile")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Ensure this matches your database column name
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false) // Ensure this matches your database column name
    private User user;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false) // Ensure this matches your database column name
    private Department department;

    @Column(name = "office_hours")
    private String officeHours;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
}
