package com.example.lab_7.Service;

import com.example.lab_7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<Student>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean updateStudent(int id, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student getStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                return students.get(i);
            }
        }
        return null;
    }

    public ArrayList<Student> getStudentGpaAbove(double gpa) {
        ArrayList<Student> studentAbove = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getGpa() >= gpa) {
                studentAbove.add(students.get(i));
            }
        }
        return studentAbove;
    }

    public boolean updateHours(int id , int hours){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.get(i).setHours(hours);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getZeroHours(){
        ArrayList<Student> zeroHours = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getHours() == 0) {
                zeroHours.add(students.get(i));
            }
        }
        return zeroHours;
    }


}
