package com.example.lab_7.Controller;

import com.example.lab_7.Api.ApiResponse;
import com.example.lab_7.Model.Student;
import com.example.lab_7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService = new StudentService();

    @GetMapping("/get")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @Valid @RequestBody Student student , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (studentService.updateStudent(id, student)) {
            return ResponseEntity.status(200).body(new ApiResponse("Student updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.status(200).body(new ApiResponse("Student deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity getByName (@PathVariable String name) {
        if (studentService.getStudent(name) != null){
            return ResponseEntity.status(200).body(studentService.getStudent(name));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
    }

    @GetMapping("/gpa/{gpa}")
    public ResponseEntity getStudentsGpa(@PathVariable double gpa){
        return ResponseEntity.status(200).body(studentService.getStudentGpaAbove(gpa));
    }

    @PutMapping("/hours/{id}")
    public ResponseEntity updateHours(@PathVariable int id ,@Valid @RequestBody int hours , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (studentService.updateHours(id, hours)) {
            return ResponseEntity.status(200).body(new ApiResponse("Hours updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
    }

    @GetMapping("/zero")
    public ResponseEntity getZeroHours(){
        return ResponseEntity.status(200).body(studentService.getZeroHours());
    }




}
