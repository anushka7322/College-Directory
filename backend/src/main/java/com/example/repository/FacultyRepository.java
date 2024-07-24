package com.example.repository;
import com.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Faculty;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> { ;
}
