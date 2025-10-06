package school.service;

import school.dto.requestDto.StudentRequestDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.StudentResponseDto;
import school.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    ApiResponse<List<StudentResponseDto>> getAllStudents();

    ApiResponse<StudentResponseDto> getStudentById(UUID id);


    ApiResponse<StudentResponseDto> add(StudentRequestDto student);

    ApiResponse<StudentResponseDto> edit(StudentRequestDto student, UUID uuid);

    ApiResponse<Void> delete(UUID uuid);


}
