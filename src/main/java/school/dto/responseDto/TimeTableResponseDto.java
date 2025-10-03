package school.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import school.enums.Period;

import java.time.LocalTime;
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
