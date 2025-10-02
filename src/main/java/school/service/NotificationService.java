package school.service;

import org.springframework.stereotype.Service;
import school.dto.requestDto.NotificationRequestDto;
import school.dto.responseDto.NotificationResponseDto;

@Service
public interface NotificationService {
    NotificationResponseDto sendNotificationResponseDto(NotificationRequestDto requestDto);
    

}
