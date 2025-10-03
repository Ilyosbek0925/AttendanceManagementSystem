package school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.dto.requestDto.AttendanceRequestDto;
import school.dto.requestDto.TeacherRequestDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.AttendanceResponseDto;
import school.dto.responseDto.TeacherResponseDto;
import school.service.AttendanceService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<ApiResponse<AttendanceResponseDto>> createTeacher(
            @RequestBody AttendanceRequestDto attendanceRequestDto) {
        return ResponseEntity.status(201).body(attendanceService.createAttendance(attendanceRequestDto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AttendanceResponseDto>>> getAllTeachers() {
        return ResponseEntity.ok(attendanceService.getAllAttendance());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AttendanceResponseDto>> getTeacherById(@PathVariable UUID id) {
        return ResponseEntity.ok(attendanceService.getAttendanceById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTeacher(@PathVariable UUID id) {
        return ResponseEntity.ok(attendanceService.deleteAttendance(id));
    }


}
