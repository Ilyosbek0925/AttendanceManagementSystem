package school.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import school.enums.Role;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminRequestDto {
    private String firstName;
    private String lastName;
    private String mail;
    private String birthday;
    private Role role;
    private String password;
}
