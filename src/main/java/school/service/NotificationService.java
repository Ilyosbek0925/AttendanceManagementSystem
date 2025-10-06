package school.service;

import school.dto.requestDto.ClassRequestDto;
import school.dto.requestDto.NotificationRequest;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.ClassResponseDto;
import school.dto.responseDto.NotificationResponse;

import java.util.List;
import java.util.UUID;

public interface NotificationService {


    ApiResponse<NotificationResponse> create(NotificationRequest dto);
    ApiResponse<List<NotificationResponse>> getAll();
    ApiResponse<NotificationResponse> getById(UUID id);
    ApiResponse<NotificationResponse> update(UUID id, NotificationRequest dto);
    ApiResponse<Void> delete(UUID id);




}
