package com.example.service;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.FacultyRepository;
import com.example.model.Faculty;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyProfileRepository;

    public Faculty saveFacultyProfile(Faculty facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    public Optional<Faculty> findById(Long id) {
        return facultyProfileRepository.findById(id);
    }

    public void deleteFacultyProfile(Long id) {
        facultyProfileRepository.deleteById(id);
    }

    public List<Faculty> findAll() {
        return facultyProfileRepository.findAll();
    }
}
