package school.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import school.dto.requestDto.StudentRequestDto;
import school.dto.responseDto.StudentResponseDto;
import school.entity.Student;
import school.repository.ClassRepository;
@RequiredArgsConstructor
@Component
public class StudentMapper {

    private ClassRepository classRepository;

private final PasswordEncoder passwordEncoder;

    public Student toStudent(StudentRequestDto student){
        Student student1 = new Student();
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setPassword(passwordEncoder.encode(student.getPassword()));
        student1.setClassEntity(classRepository.findById(student.getClassId()).orElseThrow());
        return student1;
    }


    public StudentResponseDto toStudentResponseDto(Student student){
        return StudentResponseDto.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .role(student.getRole())
                .mail(student.getMail())
                .id(student.getId())
                .birthday(student.getBirthday())
                .build();
    }



}
