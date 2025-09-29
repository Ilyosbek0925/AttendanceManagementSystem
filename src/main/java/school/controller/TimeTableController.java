package school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import school.dto.requestDto.TimeTableRequestDto;
import school.dto.responseDto.TimeTableResponseDto;
import school.service.TimeTableService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/timetable")
@RequiredArgsConstructor
public class TimeTableController {

    private final TimeTableService service;

    @PostMapping
    public TimeTableResponseDto create(@RequestBody TimeTableRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<TimeTableResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TimeTableResponseDto getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public TimeTableResponseDto update(@PathVariable UUID id, @RequestBody TimeTableRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}

