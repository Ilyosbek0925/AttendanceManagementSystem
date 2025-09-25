package school.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.entity.Student;
import school.exception.StudentNotFoundException;
import school.repository.StudentRepository;
import school.service.StudentService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Data
public class StudentServiceImpl implements StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElseThrow((() -> new StudentNotFoundException(id)));
    }

    @Override
    public Student add(Student student) {
        return null;
    }

    @Override
    public Student edit(Student student, UUID uuid) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }
}
