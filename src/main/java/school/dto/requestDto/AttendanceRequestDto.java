package school.dto.requestDto;

import school.enums.Reason;
import school.enums.ReasonType;

import java.util.UUID;

public class AttendanceRequestDto {

    private UUID studentId;

    private Reason reason;

    private ReasonType reasonType;

    private String comment;

}

