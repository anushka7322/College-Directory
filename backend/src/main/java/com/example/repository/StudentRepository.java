package com.example.repository;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
