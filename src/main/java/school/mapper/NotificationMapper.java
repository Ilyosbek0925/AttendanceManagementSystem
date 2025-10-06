package school.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.modeler.NotificationInfo;
import org.springframework.stereotype.Component;
import school.dto.requestDto.NotificationRequest;
import school.dto.responseDto.NotificationResponse;
import school.entity.Notification;
import school.entity.UserEntity;
import school.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NotificationMapper {


    private final UserRepository userEntity;
    private final UserRepository userRepository;

    public Notification toNotification(NotificationRequest notificationRequest) {
        Notification notification = new Notification();
        notification.setTitle(notificationRequest.getTitle());
        notification.setMessage(notificationRequest.getMessage());
        notification.setSender(userEntity.findById(notification.getSender().getId()).orElseThrow());
        List<UUID> recipient = notificationRequest.getRecipient();
        List<UserEntity> allById = userRepository.findAllById(recipient);
        notification.setRecipient(allById);
        return notification;
    }

    public NotificationResponse toNotificationResponse(Notification notification) {
        return NotificationResponse.builder()
                .title(notification.getTitle())
                .message(notification.getMessage())
                .sender(notification.getSender().getId())
                .recipient(notification.getRecipient().stream().map(UserEntity::getId).collect(Collectors.toList()))
                .build();
    }
}




