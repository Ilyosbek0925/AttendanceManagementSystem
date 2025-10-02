package school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.dto.requestDto.StudentRequestDto;
import school.entity.Student;
import school.service.StudentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<Student>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Student> students = studentService.getAllStudents(pageable);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/one{id}")
    public Student getById(@PathVariable UUID id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student add(@RequestBody StudentRequestDto requestDto) {
        Student student = new Student();
        student.setFirstName(requestDto.getFirstName());
        student.setLastName(requestDto.getLastName());
        student.setMail(requestDto.getEmail());
        student.setPassword(requestDto.getPassword());
        return studentService.add(student);
    }
    @PutMapping("{id}")
    public Student edit(@RequestBody StudentRequestDto requestDto, @PathVariable UUID uuid){
        return studentService.edit(requestDto,uuid);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID uuid){
        studentService.delete(uuid);
    }


}

