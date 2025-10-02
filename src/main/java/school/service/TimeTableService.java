package school.service;

import school.dto.requestDto.TimeTableRequestDto;
import school.dto.responseDto.TimeTableResponseDto;

import java.util.List;
import java.util.UUID;

public interface TimeTableService {
    TimeTableResponseDto create(TimeTableRequestDto dto);
    List<TimeTableResponseDto> getAll();
    TimeTableResponseDto getById(UUID id);
    TimeTableResponseDto update(UUID id, TimeTableRequestDto dto);
    void delete(UUID id);
}

