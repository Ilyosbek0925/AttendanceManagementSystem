package school.dto.requestDto;

import lombok.Data;

@Data
public class StudentRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
