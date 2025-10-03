package school.service.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.dto.requestDto.StudentRequestDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.StudentResponseDto;
import school.entity.Student;
import school.exception.StudentNotFoundException;
import school.mapper.StudentMapper;
import school.repository.StudentRepository;
import school.service.StudentService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    private final StudentMapper mapper;

    @Override
    public ApiResponse<List<StudentResponseDto>> getAllStudents() {
        return ApiResponse.<List<StudentResponseDto>>builder()
                .data(
                        repository.findAll().stream().map(mapper::toStudentResponseDto).collect(Collectors.toList()))
                .message("Success")
                .status(200)
                .build();
    }

    @Override
    public ApiResponse<StudentResponseDto> getStudentById(UUID id) {
        return ApiResponse.<StudentResponseDto>builder().data(repository.findById(id).map(mapper::toStudentResponseDto).orElseThrow(() -> new StudentNotFoundException(id)))
                .status(200).message("Student found successfully").build();
    }

    @Override
    public ApiResponse<StudentResponseDto> add(StudentRequestDto student) {
        Student student1 = mapper.toStudent(student);
        return ApiResponse.<StudentResponseDto>builder()
                .data(mapper.toStudentResponseDto(repository.save(student1)))
                .message("add successful").status(200).build();
    }

    @Override
    public ApiResponse<StudentResponseDto> edit(StudentRequestDto student, UUID uuid) {
        Student student1 = mapper.toStudent(student);
        student1.setId(uuid);
        return ApiResponse.<StudentResponseDto>builder().data(mapper.toStudentResponseDto(student1))
                .message("edit successful").status(200).build();


    }

    @Override
    public ApiResponse<Void> delete(UUID uuid) {
        if (repository.existsById(uuid)) {
            repository.deleteById(uuid);
        }
        throw new StudentNotFoundException(uuid);
    }
}
