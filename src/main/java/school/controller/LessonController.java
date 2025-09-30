package school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.dto.requestDto.LessonRequestDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.LessonResponseDto;
import school.service.LessonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<ApiResponse<LessonResponseDto>> createLesson(
            @RequestBody LessonRequestDto lessonRequestDto) {
        return ResponseEntity.status(201).body(lessonService.createLesson(lessonRequestDto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<LessonResponseDto>>> getAllLessons() {
        return ResponseEntity.ok(lessonService.getAllLessons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LessonResponseDto>> getLessonById(@PathVariable UUID id) {
        return ResponseEntity.ok(lessonService.getLessonById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteLesson(@PathVariable UUID id) {
        return ResponseEntity.ok(lessonService.deleteLesson(id));
    }
}
