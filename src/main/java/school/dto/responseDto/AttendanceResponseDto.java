package school.dto.responseDto;

import lombok.*;
import school.enums.Reason;
import school.enums.ReasonType;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceResponseDto {

    private Reason reason;

    private ReasonType reasonType;

    private String comment;

    private StudentResponseDto studentResponseDto;

}
