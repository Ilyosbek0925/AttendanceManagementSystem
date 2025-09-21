package school.dto.requestDto;

import lombok.Data;

@Data
public class LessonRequestDto {
    private String name;
    private String description;
    private Long teacherId;
}
