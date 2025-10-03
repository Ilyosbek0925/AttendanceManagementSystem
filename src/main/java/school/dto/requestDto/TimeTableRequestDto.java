package school.dto.requestDto;

import lombok.Data;
import school.enums.Period;

import java.time.LocalTime;

@Data
public class TimeTableRequestDto {
    private Period period;
    private LocalTime startTime;
    private LocalTime endTime;
}
