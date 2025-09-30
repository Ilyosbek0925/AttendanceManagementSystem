package school.service;

import school.dto.requestDto.TeacherRequestDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.TeacherResponseDto;

import java.util.List;
import java.util.UUID;

public interface TeacherService {
    ApiResponse<TeacherResponseDto> createTeacher(TeacherRequestDto dto);
    ApiResponse<List<TeacherResponseDto>> getAllTeachers();
    ApiResponse<TeacherResponseDto> getTeacherById(UUID id);
    ApiResponse<Void> deleteTeacher(UUID id);
}
