package school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.dto.requestDto.ClassRequestDto;
import school.dto.responseDto.ClassResponseDto;
import school.service.ClassService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/class")
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;`

    @PostMapping("/add")
    public ResponseEntity<ClassResponseDto> create(@RequestBody ClassRequestDto dto) {
        ClassResponseDto created = classService.create(dto);
        return ResponseEntity.created(URI.create("/api/classes/" + created.getUuid())).body(created);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClassResponseDto>> getAll() {
        return ResponseEntity.ok(classService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassResponseDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(classService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassResponseDto> update(@PathVariable UUID id, @RequestBody ClassRequestDto dto) {
        return ResponseEntity.ok(classService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        classService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
