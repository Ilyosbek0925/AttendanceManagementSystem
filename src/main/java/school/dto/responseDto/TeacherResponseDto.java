package school.dto.responseDto;

import lombok.Data;

import java.util.UUID;

@Data
public class TeacherResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
}
