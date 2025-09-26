package school.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassResponseDto {
    private UUID uuid;
    private String name;
    private String teacher;
    private Integer studentCount;
    private LocalDateTime created_at;
    private LocalDateTime updateAt;

}
