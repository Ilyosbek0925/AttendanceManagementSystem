package school.service;

import school.dto.requestDto.AdminRequestDto;
import school.dto.requestDto.TeacherRequestDto;
import school.dto.responseDto.AdminResponseDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.TeacherResponseDto;

import java.util.List;
import java.util.UUID;

public interface AdminService {

    ApiResponse<AdminResponseDto> createAdmin(AdminRequestDto dto);
    ApiResponse<List<AdminResponseDto>> getAllAdmins();
    ApiResponse<AdminResponseDto> getAdminById(UUID id);
    ApiResponse<Void> deleteAdmin(UUID id);

}
