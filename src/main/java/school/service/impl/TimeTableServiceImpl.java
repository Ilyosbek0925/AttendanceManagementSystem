package school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.dto.requestDto.TimeTableRequestDto;
import school.dto.responseDto.TimeTableResponseDto;
import school.entity.TimeTable;
import school.exception.ResourceNotFoundException;
import school.mapper.TimeTableMapper;
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

    private final TimeTableMapper mapper;


    @Override
    public TimeTableResponseDto create(TimeTableRequestDto dto) {

        TimeTable save = repository.save(mapper.toTimeTable(dto));
        return mapper.toTimeTableResponseDto(save);
    }

    @Override
    public List<TimeTableResponseDto> getAll() {
        List<TimeTable> entities = repository.findAll();
        return entities.stream().map(mapper::toTimeTableResponseDto).collect(Collectors.toList());
    }


    @Override
    public TimeTableResponseDto getById(UUID id) {
        TimeTable entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("TimeTable not found"));
        return mapper.toTimeTableResponseDto(entity);
    }

    @Override
    public TimeTableResponseDto update(UUID id, TimeTableRequestDto dto) {
        TimeTable timeTable = mapper.toTimeTable(dto);
        timeTable.setId(id);
        TimeTable updated = repository.save(timeTable);
        return mapper.toTimeTableResponseDto(updated);
    }

    @Override
    public void delete(UUID id) {
        if(!repository.existsById(id)){
           throw new ResourceNotFoundException("TimeTable not found with id " + id);
        }
        repository.deleteById(id);
    }


}
