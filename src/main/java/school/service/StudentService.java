package school.service;

import school.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(UUID id);

    Student add(Student student);

    Student edit(Student student,UUID uuid);

    void delete(UUID uuid);


}
