package school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.dto.requestDto.ClassRequestDto;
import school.dto.requestDto.NotificationRequest;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.ClassResponseDto;
import school.dto.responseDto.NotificationResponse;
import school.service.NotificationService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(name = "api/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<NotificationResponse>> create(@RequestBody NotificationRequest dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<NotificationResponse>>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<NotificationResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<NotificationResponse>> update(@PathVariable UUID id, @RequestBody NotificationRequest dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
