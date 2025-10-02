package school.dto.requestDto;

import lombok.Data;

@Data
public class NotificationRequestDto {
    private String senderName;
    private String receiverName;
    private String title;
    private String message;
}
