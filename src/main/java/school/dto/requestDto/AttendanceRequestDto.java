package school.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import school.enums.Reason;
import school.enums.ReasonType;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRequestDto {

    private UUID studentId;

    private Reason reason;

    private ReasonType reasonType;

    private String comment;

}

