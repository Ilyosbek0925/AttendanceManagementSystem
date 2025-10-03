package school.service;

import school.dto.requestDto.AdminRequestDto;
import school.dto.requestDto.AttendanceRequestDto;
import school.dto.responseDto.AdminResponseDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.AttendanceResponseDto;
import school.entity.Attendance;

import java.util.List;
import java.util.UUID;

public interface AttendanceService {
    ApiResponse<AttendanceResponseDto> createAttendance(AttendanceRequestDto dto);
    ApiResponse<List<AttendanceResponseDto>> getAllAttendance();
    ApiResponse<AttendanceResponseDto> getAttendanceById(UUID id);
    ApiResponse<Void> deleteAttendance(UUID id);
}
