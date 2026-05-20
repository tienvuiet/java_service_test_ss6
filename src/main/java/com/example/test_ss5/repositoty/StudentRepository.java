package com.example.test_ss5.repositoty;

import com.example.test_ss5.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
