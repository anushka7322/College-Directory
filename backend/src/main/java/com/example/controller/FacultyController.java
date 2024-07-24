package com.example.controller;
import com.example.model.Faculty;
import com.example.model.Student;
import com.example.model.User;
import com.example.service.FacultyService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculty")
@CrossOrigin(origins = "http://localhost:3000/")
public class FacultyController {
    @Autowired()
    private FacultyService facultyService;
    @Autowired()
    private UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserById(@PathVariable String username) {
        Optional<User> optionalUser = userService.getUserByUsername(username);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = optionalUser.get();
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public List<Faculty> getAllFaculty() {
        return facultyService.findAll();
    }

}
