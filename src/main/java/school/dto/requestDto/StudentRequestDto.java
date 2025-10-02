package school.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
