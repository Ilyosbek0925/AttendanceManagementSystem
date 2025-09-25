package school.dto.requestDto;

import lombok.Data;

@Data
public class StudentCreateDto {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Integer classId;
}
