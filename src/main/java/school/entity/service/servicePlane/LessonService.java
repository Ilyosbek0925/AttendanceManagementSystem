package school.service.servicePlane;

import school.dto.requestDto.LessonRequestDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.LessonResponseDto;

import java.util.List;
import java.util.UUID;

public interface LessonService {
    ApiResponse<LessonResponseDto> createLesson(LessonRequestDto dto);
    ApiResponse<List<LessonResponseDto>> getAllLessons();
    ApiResponse<LessonResponseDto> getLessonById(UUID id);
    ApiResponse<Void> deleteLesson(UUID id);
}
