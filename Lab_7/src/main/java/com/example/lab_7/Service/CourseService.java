package com.example.lab_7.Service;


import com.example.lab_7.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {

    ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean updateCourse(int id ,Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateCapacity(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.get(i).setCapacity(courses.get(i).getCapacity() - 1);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Course> getZeroCapacity(){
        ArrayList<Course> zeroCapacity = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCapacity() == 0) {
                zeroCapacity.add(courses.get(i));
            }
        }
        return zeroCapacity;
    }

    public Course getCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                return courses.get(i);
            }
        }
        return null;
    }

    public ArrayList<Course> getCourseByDepartment(String department) {
        ArrayList<Course> courseByDepartment = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getDepartment().equals(department)) {
                courseByDepartment.add(courses.get(i));
            }
        }
        return courseByDepartment;
    }






}
