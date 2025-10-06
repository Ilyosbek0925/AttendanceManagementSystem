package school.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.dto.requestDto.NotificationRequest;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.NotificationResponse;
import school.entity.Notification;
import school.exception.ResourceNotFoundException;
import school.mapper.NotificationMapper;
import school.repository.NotificationRepository;
import school.service.NotificationService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationImpl implements NotificationService {

    private final NotificationRepository repository;

    private final NotificationMapper mapper;


    @Override
    public ApiResponse<NotificationResponse> create(NotificationRequest dto) {
        Notification notification = mapper.toNotification(dto);
        return ApiResponse.<NotificationResponse>builder().data(mapper.toNotificationResponse(notification)).status(200).message("created successfully").build();
    }

    @Override
    public ApiResponse<List<NotificationResponse>> getAll() {
        List<Notification> all = repository.findAll();

        List<NotificationResponse> list = all.stream().map(mapper::toNotificationResponse).toList();
        return ApiResponse.<List<NotificationResponse>>builder()
                .data(list)
                .status(200)
                .message("successfully getting all notifications").build();
    }

    @Override
    public ApiResponse<NotificationResponse> getById(UUID id) {
        Notification notification = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notification id not found"));
        return ApiResponse.<NotificationResponse>builder().data(mapper.toNotificationResponse(notification)).status(200).message("successfully getting notification").build();
    }

    @Override
    public ApiResponse<NotificationResponse> update(UUID id, NotificationRequest dto) {
        Notification notification =
                mapper.toNotification(dto);
notification.setId(id);
return ApiResponse.<NotificationResponse>builder()
        .data(mapper.toNotificationResponse(repository.save(notification)))
        .status(200).message("successfully updated notification").build();
    }

    @Override
    public ApiResponse<Void> delete(UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ApiResponse.<Void>builder()
                .message("successfully deleted notification").build();
        }
        throw new ResourceNotFoundException("Notification id not found");
    }


}
