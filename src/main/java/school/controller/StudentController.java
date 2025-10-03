package school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.dto.requestDto.AdminRequestDto;
import school.dto.requestDto.StudentRequestDto;
import school.dto.responseDto.AdminResponseDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.StudentResponseDto;
import school.service.StudentService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/student")
public class StudentController {

private final StudentService studentService;


    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponseDto>> createTeacher(
            @RequestBody StudentRequestDto studentRequestDto) {
        return ResponseEntity.status(201).body(studentService.add(studentRequestDto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponseDto>>> getAllTeachers() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDto>> getTeacherById(@PathVariable UUID id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTeacher(@PathVariable UUID id) {
        return ResponseEntity.ok(studentService.delete(id));
    }



}
