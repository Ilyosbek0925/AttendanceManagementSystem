package school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.dto.requestDto.TeacherRequestDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.TeacherResponseDto;
import school.entity.Teacher;
import school.mapper.TeacherMapper;
import school.repository.TeacherRepository;
import school.service.TeacherService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public ApiResponse<TeacherResponseDto> createTeacher(TeacherRequestDto dto) {
        teacherRepository.findByMail(dto.getMail()).ifPresent(t -> {
            throw new RuntimeException("Teacher with this email already exists");
        });

        Teacher teacher = teacherMapper.toEntity(dto);
        Teacher saved = teacherRepository.save(teacher);
        return ApiResponse.<TeacherResponseDto>builder()
                .status(201)
                .message("Teacher created")
                .data(teacherMapper.toDto(saved))
                .build();
    }

    @Override
    public ApiResponse<List<TeacherResponseDto>> getAllTeachers() {
        List<TeacherResponseDto> list = teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toDto)
                .collect(Collectors.toList());
        return ApiResponse.<List<TeacherResponseDto>>builder()
                .status(200)
                .message("All teachers")
                .data(list)
                .build();
    }

    @Override
    public ApiResponse<TeacherResponseDto> getTeacherById(UUID id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        return ApiResponse.<TeacherResponseDto>builder()
                .status(200)
                .message("Teacher found")
                .data(teacherMapper.toDto(teacher))
                .build();
    }

    @Override
    public ApiResponse<Void> deleteTeacher(UUID id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        teacherRepository.delete(teacher);
        return ApiResponse.<Void>builder()
                .status(200)
                .message("Teacher deleted")
                .build();
    }
}
