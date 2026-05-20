package com.example.test_ss5.controller;


import com.example.test_ss5.model.dto.response.ApiDataResponse;
import com.example.test_ss5.model.entity.Student;
import com.example.test_ss5.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    // lay student
    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Student>>> getStudents(){
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Lay danh sach student thanh cong",
                        studentService.getStudents(),
                        HttpStatus.OK
                ), HttpStatus.OK
        );
    }

    // them student
    @PostMapping
    public ResponseEntity<ApiDataResponse<Student>> insertStudent(
            @RequestBody Student student
    ){
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Them student thanh cong",
                        studentService.insertStudent(student),
                        HttpStatus.CREATED
                ),
                HttpStatus.CREATED
        );
    }

    //update toan bo
    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Student>> updateAllStudent(
            @PathVariable Long id,
            @RequestBody Student student
    ){
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Update all student success",
                        studentService.updateAllStudent(id, student),
                        HttpStatus.OK
                ), HttpStatus.OK
        );
    }

    //update tung phan
    @PatchMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Student>> updatePartialStudent(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates
            ){
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "update partial student success",
                        studentService.updatePartialStudent(id, updates),
                        HttpStatus.OK
                ), HttpStatus.OK
        );
    }


    // xoa student theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Boolean>> deleteStudentById(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "student delete success",
                        studentService.deleteStudentById(id),
                        HttpStatus.OK
                ), HttpStatus.OK
        );
    }
}
