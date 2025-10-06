package school.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import school.dto.requestDto.TeacherRequestDto;
import school.dto.responseDto.TeacherResponseDto;
import school.entity.Teacher;

@Component
@RequiredArgsConstructor
public class TeacherMapper {

    private final PasswordEncoder passwordEncoder;

    public Teacher toEntity(TeacherRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setMail(dto.getMail());
        teacher.setBirthday(dto.getBirthday());
        teacher.setPassword(passwordEncoder.encode(dto.getPassword()));
        return teacher;
    }

    public TeacherResponseDto toDto(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        return TeacherResponseDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .email(teacher.getMail())
                .build();
    }
}
