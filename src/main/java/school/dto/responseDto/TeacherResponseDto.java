package school.dto.responseDto;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
}
