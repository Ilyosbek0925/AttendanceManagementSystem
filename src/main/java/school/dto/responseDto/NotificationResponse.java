package school.dto.responseDto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponse {
    private UUID id;
    private UUID sender;
    private List<UUID> recipient;
    private String title;
    private String message;
}
