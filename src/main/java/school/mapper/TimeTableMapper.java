package school.mapper;

import org.springframework.stereotype.Component;
import school.dto.requestDto.TimeTableRequestDto;
import school.dto.responseDto.TimeTableResponseDto;
import school.entity.TimeTable;

@Component
public class TimeTableMapper {

public TimeTable toTimeTable(TimeTableRequestDto requestDto) {
TimeTable timeTable = new TimeTable();
timeTable.setStartTime(requestDto.getStartTime());
timeTable.setEndTime(requestDto.getEndTime());
timeTable.setPeriod(requestDto.getPeriod());
return timeTable;
}


public TimeTableResponseDto toTimeTableResponseDto(TimeTable timeTable) {

    return TimeTableResponseDto.builder()
            .startTime(timeTable.getStartTime())
            .endTime(timeTable.getEndTime())
            .periodNumber(timeTable.getPeriod())
            .build();
}


}
