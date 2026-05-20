package com.example.test_ss5.service.impl;

import com.example.test_ss5.model.entity.Student;
import com.example.test_ss5.repositoty.StudentRepository;
import com.example.test_ss5.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateAllStudent(Long id, Student student) {
        studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("studentId not found"));
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    public Student updatePartialStudent(Long id, Map<String, Object> updates) {
        Student existingStudent =  studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("studentId not found"));
        if (updates.containsKey("fullName")){
            existingStudent.setFullName((String) updates.get("fullName"));
        }
        if (updates.containsKey("email")){
            existingStudent.setEmail((String) updates.get("email"));
        }
        if (updates.containsKey("gpa")){
            existingStudent.setGpa(Double.valueOf(updates.get("gpa").toString()));
        }

        return studentRepository.save(existingStudent);
    }

    @Override
    public Boolean deleteStudentById(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("studentId not found"));
        studentRepository.deleteById(id);
        return true;

    }
}
