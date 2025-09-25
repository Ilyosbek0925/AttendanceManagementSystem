package school.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForgetPasswordDto {
    @Email(message = "mail cannot be empty")
    private String mail;
    @NotBlank(message = "code cannot be empty")
    private Integer code;

}
