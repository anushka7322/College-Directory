package com.example.model;
import jakarta.persistence.*;

@Entity
public class Administrator {
    @Id
    private Long userId;

    private String photo;

    @ManyToOne
    @JoinColumn(name="department_id", nullable = false)
    private Department department;

    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    private User user;

    // getters and setters


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
