package school.dto.requestDto;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonRequestDto {
    private String name;
    private String description;
    private UUID teacherId; // which teacher this lesson belongs to
}
