package com.example.service;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.StudentRepository;
import com.example.model.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentProfileRepository;

    public Student saveStudentProfile(Student studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }


    public Optional<Student> findById(Long id) {
        return studentProfileRepository.findById(id);
    }

    public boolean deleteStudentProfile(Long id) {
        if(studentProfileRepository.existsById(id)) {
            studentProfileRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Student> findAll() {
        return studentProfileRepository.findAll();
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Optional<Student> optionalStudent = studentProfileRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setPhoto(studentDetails.getPhoto());
            student.setDepartmentClass(studentDetails.getDepartmentClass());
            student.setYear(studentDetails.getYear());
            student.setUserId(studentDetails.getUserId());
            return studentProfileRepository.save(student);
        }
        return null;
    }

}
