package school.service.impl;

import org.springframework.stereotype.Service;
import school.dto.requestDto.AttendanceRequestDto;
import school.dto.responseDto.AdminResponseDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.AttendanceResponseDto;
import school.service.AttendanceService;

import java.util.List;
import java.util.UUID;

@Service
public class AttendanceImpl implements AttendanceService {
    @Override
    public ApiResponse<AdminResponseDto> createAttendance(AttendanceRequestDto dto) {
        return null;
    }

    @Override
    public ApiResponse<List<AttendanceResponseDto>> getAllAttendance() {
        return null;
    }

    @Override
    public ApiResponse<AttendanceResponseDto> getAttendanceById(UUID id) {
        return null;
    }

    @Override
    public ApiResponse<Void> deleteAttendance(UUID id) {
        return null;
    }


}
