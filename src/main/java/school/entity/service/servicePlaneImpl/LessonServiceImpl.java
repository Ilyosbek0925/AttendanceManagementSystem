package school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.dto.requestDto.LessonRequestDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.LessonResponseDto;
import school.entity.Lesson;
import school.entity.Teacher;
import school.mapper.LessonMapper;
import school.repository.LessonRepository;
import school.repository.TeacherRepository;
import school.service.servicePlane.LessonService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final TeacherRepository teacherRepository;
    private final LessonMapper lessonMapper;

    @Override
    public ApiResponse<LessonResponseDto> createLesson(LessonRequestDto dto) {
        Teacher teacher = null;
        if (dto.getTeacherId() != null) {
            teacher = teacherRepository.findById(dto.getTeacherId())
                    .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + dto.getTeacherId()));
        }

        Lesson lesson = lessonMapper.toEntity(dto, teacher);
        Lesson saved = lessonRepository.save(lesson);

        return ApiResponse.<LessonResponseDto>builder()
                .status(201)
                .message("Lesson created successfully")
                .data(lessonMapper.toDto(saved))
                .build();
    }

    @Override
    public ApiResponse<List<LessonResponseDto>> getAllLessons() {
        List<LessonResponseDto> lessons = lessonRepository.findAll()
                .stream()
                .map(lessonMapper::toDto)
                .collect(Collectors.toList());

        return ApiResponse.<List<LessonResponseDto>>builder()
                .status(200)
                .message("All lessons fetched")
                .data(lessons)
                .build();
    }

    @Override
    public ApiResponse<LessonResponseDto> getLessonById(UUID id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));

        return ApiResponse.<LessonResponseDto>builder()
                .status(200)
                .message("Lesson found")
                .data(lessonMapper.toDto(lesson))
                .build();
    }

    @Override
    public ApiResponse<Void> deleteLesson(UUID id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));

        lessonRepository.delete(lesson);

        return ApiResponse.<Void>builder()
                .status(200)
                .message("Lesson deleted successfully")
                .build();
    }
}
