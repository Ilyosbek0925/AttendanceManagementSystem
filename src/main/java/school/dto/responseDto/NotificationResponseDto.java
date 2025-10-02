package school.dto.responseDto;

import lombok.Data;

import java.util.UUID;

@Data
public class NotificationResponseDto {
    private UUID id;
    private String title;
    private String message;
    private String firstName;
    private String lastName;
    private boolean isRead;
    private UUID senderId;
    private String senderName;
    private UUID receiverId;
    private String receiverName;

}
