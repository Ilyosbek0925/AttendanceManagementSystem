package school.mapper;

import org.mapstruct.Mapper;
import school.dto.requestDto.NotificationRequestDto;
import school.dto.responseDto.NotificationResponseDto;
import school.entity.Notification;
import school.entity.UserEntity;

@Mapper(componentModel = "spring")
public class NotificationMapper {


    public static Notification toEntity(NotificationRequestDto dto, UserEntity sender, UserEntity receiver) {
        Notification notification = new Notification();
        notification.setSender(sender);
        notification.setReceiver(receiver);
        notification.setTitle(dto.getTitle());
        notification.setMessage(dto.getMessage());
        notification.setRead(false);
        return notification;
    }


    public static NotificationResponseDto toDto(Notification notification) {
        NotificationResponseDto dto = new NotificationResponseDto();
        dto.setId(notification.getId());
        dto.setTitle(notification.getTitle());
        dto.setMessage(notification.getMessage());
        dto.setRead(notification.isRead());
        dto.setSenderId(notification.getSender().getId());
        dto.setSenderName(notification.getSender().getUsername());
        dto.setReceiverId(notification.getReceiver().getId());
        dto.setReceiverName(notification.getReceiver().getUsername());
        return dto;
    }

}



