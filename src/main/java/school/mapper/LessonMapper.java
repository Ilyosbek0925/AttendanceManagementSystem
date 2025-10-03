package school.mapper;

import org.springframework.stereotype.Component;
import school.dto.requestDto.LessonRequestDto;
import school.dto.responseDto.LessonResponseDto;
import school.entity.Lesson;
import school.entity.Teacher;

@Component
public class LessonMapper {

    private TeacherMapper teacherMapper;

    public Lesson toEntity(LessonRequestDto dto, Teacher teacher) {
        if (dto == null) return null;
        return Lesson.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .teacher(teacher)
                .build();
    }

    public LessonResponseDto toDto(Lesson entity) {
        if (entity == null) return null;
        return LessonResponseDto.builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .name(entity.getName())
                .teacherResponseDto(teacherMapper.toDto(entity.getTeacher()))
                .build();
    }
}
