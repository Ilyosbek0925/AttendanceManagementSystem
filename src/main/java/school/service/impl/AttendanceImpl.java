package school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.dto.requestDto.AttendanceRequestDto;
import school.dto.responseDto.AdminResponseDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.AttendanceResponseDto;
import school.entity.Attendance;
import school.exception.ResourceNotFoundException;
import school.mapper.AttendanceMapper;
import school.repository.AttendanceRepository;
import school.repository.StudentRepository;
import school.service.AttendanceService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AttendanceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;

private final AttendanceMapper mapper;

    @Override
    public ApiResponse<AttendanceResponseDto> createAttendance(AttendanceRequestDto dto) {
        Attendance save = attendanceRepository.save(mapper.toAttendance(dto));
        AttendanceResponseDto attendanceResponseDto = mapper.toAttendanceResponseDto(save);
        return ApiResponse.<AttendanceResponseDto>builder()
                .data(attendanceResponseDto)
                .status(200)
                .message("Successfully created the attendance")
                .build();
    }

    @Override
    public ApiResponse<List<AttendanceResponseDto>> getAllAttendance() {

        List<AttendanceResponseDto> list = attendanceRepository.findAll().stream().map(mapper::toAttendanceResponseDto).toList();
        return ApiResponse.<List<AttendanceResponseDto>>builder()
                .data(list)
                .status(200)
                .message("Successfully retrieved all the attendance")
                .build();
    }

    @Override
    public ApiResponse<AttendanceResponseDto> getAttendanceById(UUID id) {
        AttendanceResponseDto attendanceResponseDto = mapper.toAttendanceResponseDto(attendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attendance with id: " + id + " not found!")));
        return ApiResponse.<AttendanceResponseDto>builder()
                .message("Successfully retrieved the attendance")
                .data(attendanceResponseDto)
                .status(200)
                .build();
    }

    @Override
    public ApiResponse<Void> deleteAttendance(UUID id) {
        if(attendanceRepository.findById(id).isPresent()) {
            attendanceRepository.deleteById(id);
        }
        throw new ResourceNotFoundException("Attendance with id: " + id + " not found!");
    }


}
