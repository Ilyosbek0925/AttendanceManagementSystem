package school.dto.responseDto;

import lombok.Data;

import java.util.UUID;

@Data
public class LessonResponseDto {
    private UUID id;
    private String name;
    private String description;
    private String teacherFullName;
}
