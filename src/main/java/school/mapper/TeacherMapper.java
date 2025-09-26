package school.mapper;

import org.springframework.stereotype.Component;
import school.dto.requestDto.TeacherRequestDto;
import school.dto.responseDto.TeacherResponseDto;
import school.entity.Teacher;

@Component
public class TeacherMapper {

    public Teacher toEntity(TeacherRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return Teacher.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();
    }

    public TeacherResponseDto toDto(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        return TeacherResponseDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .email(teacher.getEmail())
                .build();
    }
}
