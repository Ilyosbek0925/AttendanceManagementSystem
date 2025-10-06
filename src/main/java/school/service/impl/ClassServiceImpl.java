package school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.dto.requestDto.ClassRequestDto;
import school.dto.responseDto.ClassResponseDto;
import school.entity.ClassEntity;
import school.exception.ResourceNotFoundException;
import school.mapper.ClassMapper;
import school.repository.ClassRepository;
import school.service.ClassService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ClassServiceImpl implements ClassService {

    private final ClassRepository repository;

    @Override
    public ClassResponseDto create(ClassRequestDto dto) {
        ClassEntity entity = ClassMapper.toEntity(dto);
        ClassEntity saved = repository.save(entity);
        return ClassMapper.toDto(saved);
    }

    @Override
    public List<ClassResponseDto> getAll() {
        return repository.findAll().stream()
                .map(ClassMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClassResponseDto getById(UUID id) {
        ClassEntity e = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found with id: " + id));
        return ClassMapper.toDto(e);
    }

    @Override
    public ClassResponseDto update(UUID id, ClassRequestDto dto) {
        ClassEntity existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found with id: " + id));
        existing.setName(dto.getName());
        existing.setStudentCount(dto.getStudentCount() != null ? dto.getStudentCount() : existing.getStudentCount());
        repository.save(existing);
        return ClassMapper.toDto(existing);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Class not found with id: " + id);
        }
        repository.deleteById(id);
    }

}

