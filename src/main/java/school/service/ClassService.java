package school.service;

import school.dto.requestDto.ClassRequestDto;
import school.dto.responseDto.ClassResponseDto;

import java.util.List;
import java.util.UUID;

public interface ClassService {
    ClassResponseDto create(ClassRequestDto dto);
    List<ClassResponseDto> getAll();
    ClassResponseDto getById(UUID id);
    ClassResponseDto update(UUID id,ClassRequestDto dto);
    void delete(UUID id);

}
