package school.mapper;

import school.dto.requestDto.ClassRequestDto;
import school.dto.responseDto.ClassResponseDto;
import school.entity.ClassEntity;

public class ClassMapper {
    public static ClassEntity toEntity(ClassRequestDto dto) {
        if (dto == null) return null;
        ClassEntity entity = new ClassEntity();
        entity.setName(dto.getName());
        entity.setTeacher(dto.getTeacher());
        entity.setStudentCount(dto.getStudentCount() != null ? dto.getStudentCount() : 0);
        return entity;
    }
    public static ClassResponseDto toDto(ClassEntity entity){
        if (entity==null) return null;
        return ClassResponseDto.builder()
                .uuid(entity.getUuid())
                .name(entity.getName())
                .teacher(entity.getTeacher())
                .studentCount(entity.getStudentCount())
                .created_at(entity.getCreatedAt())
                .updateAt(entity.getUpdatedAt())
                .build();

    }
}
