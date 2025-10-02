package school.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import school.dto.requestDto.StudentRequestDto;
import school.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(source = "email", target = "mail")
    Student toEntity(StudentRequestDto dto);

    void updateStudentFromDto(StudentRequestDto studentRequestDto,
                              @MappingTarget Student student);

}
