package school.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import school.dto.requestDto.StudentRequestDto;
import school.entity.Student;
import java.util.UUID;

public interface StudentService {

    Page<Student> getAllStudents(Pageable pageable);

    Student getStudentById(UUID id);

    Student add(Student student);
    Student edit(StudentRequestDto studentRequestDto, UUID uuid);

    void delete(UUID uuid);


}
