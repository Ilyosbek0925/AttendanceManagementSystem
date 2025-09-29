package school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.dto.requestDto.TimeTableRequestDto;
import school.dto.responseDto.TimeTableResponseDto;
import school.entity.TimeTable;
import school.exception.ResourceNotFoundException;
import school.repository.TimeTableRepository;
import school.service.TimeTableService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeTableServiceImpl implements TimeTableService {

    private final TimeTableRepository repository;

    @Override
    public TimeTableResponseDto create(TimeTableRequestDto dto) {
        TimeTable entity = new TimeTable();
        entity.setLessonNumber(dto.getLessonNumber());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());

        TimeTable saved = repository.save(entity);
        return mapToDto(saved);
    }

    @Override
    public List<TimeTableResponseDto> getAll() {
        List<TimeTable> entities = repository.findAll();
        List<TimeTableResponseDto> dtos = new ArrayList<>();
        for (TimeTable e : entities) {
            dtos.add(mapToDto(e));
        }
        return dtos;
    }


    @Override
    public TimeTableResponseDto getById(UUID id) {
        TimeTable entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("TimeTable not found"));
        return mapToDto(entity);
    }

    @Override
    public TimeTableResponseDto update(UUID id, TimeTableRequestDto dto) {
        TimeTable entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TimeTable not found"));

        entity.setLessonNumber(dto.getLessonNumber());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());

        TimeTable updated = repository.save(entity);
        return mapToDto(updated);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private TimeTableResponseDto mapToDto(TimeTable e) {
        return new TimeTableResponseDto(
                e.getId(),
                e.getLessonNumber(),
                e.getStartTime(),
                e.getEndTime(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
