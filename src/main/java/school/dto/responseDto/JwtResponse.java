package school.dto.responseDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {
    private String token;

}
