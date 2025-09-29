package school.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import school.dto.requestDto.StudentRequestDto;
import school.dto.responseDto.StudentResponseDto;
import school.entity.Student;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentRequestDto dto);
    void updateStudentFromDto(StudentRequestDto studentRequestDto, @MappingTarget Student student);

}
