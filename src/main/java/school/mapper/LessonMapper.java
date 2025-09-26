package school.mapper;

import org.springframework.stereotype.Component;
import school.dto.requestDto.LessonRequestDto;
import school.dto.responseDto.LessonResponseDto;
import school.entity.Lesson;
import school.entity.Teacher;

@Component
public class LessonMapper {

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

        String teacherFullName = null;
        if (entity.getTeacher() != null) {
            teacherFullName =
                    (entity.getTeacher().getFirstName() == null ? "" : entity.getTeacher().getFirstName())
                            + " "
                            + (entity.getTeacher().getLastName() == null ? "" : entity.getTeacher().getLastName());
            teacherFullName = teacherFullName.trim();
        }

        return LessonResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .teacherFullName(teacherFullName)
                .build();
    }
}
