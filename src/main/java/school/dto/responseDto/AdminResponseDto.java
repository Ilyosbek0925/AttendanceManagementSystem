package school.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import school.enums.Role;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String mail;
    private String birthday;
    private Role role;
}
