package com.example.controller;
import com.example.model.Student;
import com.example.model.User;
import com.example.service.StudentService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000/")
public class StudentController {
    @Autowired()
    private StudentService studentService;
    @Autowired()
    private UserService userService;

    @GetMapping()
    public List<Student> findAll() {
        return studentService.findAll();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        Optional<Student> optionalStudent = studentService.findById(id);
        if (optionalStudent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Student studentClass = optionalStudent.get();
        return ResponseEntity.ok(studentClass);
    }

    @PostMapping
    public Student saveStudentProfile(@RequestBody Student studentClass) {
        return studentService.saveStudentProfile(studentClass);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserById(@PathVariable String username) {

        Optional<User> optionalUser = userService.getUserByUsername(username);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = optionalUser.get();
        return ResponseEntity.ok(user);
    }

    // Update an existing student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentProfile(@PathVariable Long id) {
        if(!studentService.deleteStudentProfile(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
