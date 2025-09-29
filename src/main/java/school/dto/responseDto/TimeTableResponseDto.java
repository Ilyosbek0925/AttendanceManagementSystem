package school.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TimeTableResponseDto {
    private UUID uuid;
    private int lessonNumber;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;
}
