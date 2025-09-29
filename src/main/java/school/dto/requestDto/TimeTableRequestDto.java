package school.dto.requestDto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TimeTableRequestDto {
    private int lessonNumber;
    private LocalTime startTime;
    private LocalTime endTime;
}
