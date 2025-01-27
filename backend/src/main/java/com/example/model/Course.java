package com.example.model;
import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name="department_id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name="faculty_id", nullable = false)
    private Faculty faculty;

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
