package school.dto.responseDto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class ApiResponse<T>{
    private String message;
    private T data;
    private Integer status;
}
