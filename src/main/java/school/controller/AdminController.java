package school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.dto.requestDto.AdminRequestDto;
import school.dto.requestDto.TeacherRequestDto;
import school.dto.responseDto.AdminResponseDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.TeacherResponseDto;
import school.service.AdminService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/admin")
@RequiredArgsConstructor
public class AdminController {
private final AdminService adminService;


    @PostMapping
    public ResponseEntity<ApiResponse<AdminResponseDto>> createTeacher(
            @RequestBody AdminRequestDto adminRequestDto) {
        return ResponseEntity.status(201).body(adminService.createAdmin(adminRequestDto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AdminResponseDto>>> getAllTeachers() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AdminResponseDto>> getTeacherById(@PathVariable UUID id) {
        return ResponseEntity.ok(adminService.getAdminById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTeacher(@PathVariable UUID id) {
        return ResponseEntity.ok(adminService.deleteAdmin(id));
    }
}
