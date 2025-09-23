package school.mapper;

import school.dto.requestDto.TeacherRequestDto;
import school.dto.responseDto.TeacherResponseDto;
import school.entity.Teacher;

public interface TeacherMapper {

    static Teacher toEntity(TeacherRequestDto dto) {
        if (dto == null) return null;

        return Teacher.builder()
                .fullName(dto.getFirstName() + " " + dto.getLastName())
                .build();
    }

    static TeacherResponseDto toResponseDto(Teacher entity) {
        if (entity == null) return null;

        TeacherResponseDto dto = new TeacherResponseDto();
        dto.setId(entity.getId());

        if (entity.getFullName() != null) {
            String[] parts = entity.getFullName().split(" ", 2);
            dto.setFirstName(parts.length > 0 ? parts[0] : "");
            dto.setLastName(parts.length > 1 ? parts[1] : "");
        }

        dto.setEmail(null);

        return dto;
    }
}
