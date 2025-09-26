package school.dto.responseDto;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonResponseDto {
    private UUID id;
    private String name;
    private String description;
    private String teacherFullName; // e.g. "John Doe"
}
