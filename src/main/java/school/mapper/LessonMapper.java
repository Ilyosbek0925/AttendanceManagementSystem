package school.mapper;

import school.dto.requestDto.LessonRequestDto;
import school.dto.responseDto.LessonResponseDto;
import school.entity.Lesson;
import school.entity.Teacher;

public interface LessonMapper {

    static Lesson toEntity(LessonRequestDto dto, Teacher teacher) {
        if (dto == null) return null;

        return Lesson.builder()
                .subject(dto.getName())
                .className(dto.getDescription())
                .teacher(teacher)
                .build();
    }

    static LessonResponseDto toResponseDto(Lesson entity) {
        if (entity == null) return null;

        LessonResponseDto dto = new LessonResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getSubject());
        dto.setDescription(entity.getClassName());
        dto.setTeacherFullName(
                entity.getTeacher() != null ? entity.getTeacher().getFullName() : null
        );

        return dto;
    }
}
