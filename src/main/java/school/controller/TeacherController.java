package school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.dto.requestDto.TeacherRequestDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.TeacherResponseDto;
import school.service.TeacherService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<ApiResponse<TeacherResponseDto>> createTeacher(
            @RequestBody TeacherRequestDto teacherRequestDto) {
        return ResponseEntity.status(201).body(teacherService.createTeacher(teacherRequestDto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TeacherResponseDto>>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherResponseDto>> getTeacherById(@PathVariable UUID id) {
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTeacher(@PathVariable UUID id) {
        return ResponseEntity.ok(teacherService.deleteTeacher(id));
    }
}
