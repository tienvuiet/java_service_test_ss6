package com.example.test_ss5.service;

import com.example.test_ss5.model.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> getStudents();
    Student insertStudent(Student student);
    Student updateAllStudent(Long id, Student student);
    Student updatePartialStudent(Long id, Map<String, Object> updates);
    Boolean deleteStudentById(Long id);
}
