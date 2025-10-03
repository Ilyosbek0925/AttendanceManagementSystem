package school.dto.requestDto;

import lombok.*;
import school.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherRequestDto {
    private String firstName;
    private String lastName;
    private String mail;
    private String birthday;
    private Role role;
}
