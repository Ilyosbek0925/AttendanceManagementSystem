package school.dto.requestDto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherRequestDto {
    private String firstName;
    private String lastName;
    private String email;
}
