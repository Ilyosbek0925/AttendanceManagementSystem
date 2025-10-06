package school.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.enums.Role;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    private String firstName;
    private String lastName;
    private String mail;
    private String birthday;
    private Role role;
    private UUID classId;
    private String password;
}
