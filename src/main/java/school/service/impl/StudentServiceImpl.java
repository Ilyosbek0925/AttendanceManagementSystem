package school.service.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.dto.requestDto.StudentRequestDto;
import school.entity.Student;
import school.exception.StudentNotFoundException;
import school.mapper.StudentMapper;
import school.repository.StudentRepository;
import school.service.StudentService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Data
public class StudentServiceImpl implements StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public Student add(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student edit(StudentRequestDto studentRequestDto, UUID uuid) {
        Student student=studentRepository.findById(uuid).orElseThrow(() -> new StudentNotFoundException(uuid));
        studentMapper.updateStudentFromDto(studentRequestDto,student);
        return studentRepository.save(student);

    }

    @Override
    public void delete(UUID uuid) {
        Student student=studentRepository.findById(uuid).orElseThrow(() -> new StudentNotFoundException(uuid));
        studentRepository.deleteById(uuid);
    }
}
