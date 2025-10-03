package school.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TimeTableResponseDto {
    private UUID uuid;
    private Period periodNumber;
    private LocalTime startTime;
    private LocalTime endTime;
}
