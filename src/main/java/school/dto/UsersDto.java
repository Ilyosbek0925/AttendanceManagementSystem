package school.dto;

import lombok.*;
import school.enums.Role;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsersDto {
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
