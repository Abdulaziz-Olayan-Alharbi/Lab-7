package com.example.lab_7.Controller;


import com.example.lab_7.Api.ApiResponse;
import com.example.lab_7.Model.Course;
import com.example.lab_7.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService= new CourseService();


    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getCourses());
    }


    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable int id,@Valid @RequestBody Course course , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (courseService.updateCourse(id,course)) {
            return ResponseEntity.status(200).body(new ApiResponse("Course updated"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Course not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable int id) {
        if (courseService.deleteCourse(id)) {
            return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Course not found"));
    }

    @PutMapping("/capacity/{id}")
    public ResponseEntity updateCapacityByOne(@PathVariable int id) {
        if (courseService.updateCapacity(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Capacity updated"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Course not found"));
    }

    @GetMapping("/getzero")
    public ResponseEntity getZeroCapacity(){
        return ResponseEntity.status(200).body(courseService.getZeroCapacity());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity findCourseById(@PathVariable int id) {
        if (courseService.getCourse(id) != null) {
            return ResponseEntity.status(200).body(courseService.getCourse(id));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Course not found"));
    }

    @GetMapping("department/{department}")
    public ResponseEntity getCoursesByDepartment(@PathVariable String department) {
        return ResponseEntity.status(200).body(courseService.getCourseByDepartment(department));
    }



}
