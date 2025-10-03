package school.dto.requestDto;

import lombok.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonRequestDto {

    private String name;

    private String description;

    private UUID teacherId;

    private List<DayOfWeek>dayOfWeek;




}
