package school.dto.responseDto;

import school.enums.Reason;
import school.enums.ReasonType;

import java.util.UUID;

public class AttendanceResponseDto {

    private Reason reason;

    private ReasonType reasonType;

    private String comment;

    private StudentResponseDto studentResponseDto;

}
