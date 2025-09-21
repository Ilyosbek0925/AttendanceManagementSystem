package school.dto.responseDto;

import lombok.Data;

@Data
public class LessonResponseDto {
    private Long id;
    private String name;
    private String description;
    private String teacherFullName;
}
