package school.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.dto.requestDto.AdminRequestDto;
import school.dto.responseDto.AdminResponseDto;
import school.dto.responseDto.ApiResponse;
import school.entity.AdminEntity;
import school.exception.AdminNotFoundException;
import school.mapper.AdminMapper;
import school.repository.AdminRepository;
import school.service.AdminService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper mapper;

    @Override
    public ApiResponse<AdminResponseDto> createAdmin(AdminRequestDto dto) {
        AdminEntity admin = mapper.toAdmin(dto);
        AdminEntity save = adminRepository.save(admin);
        log.info("Admin created successfully");
        return ApiResponse.<AdminResponseDto>builder()
                .data(mapper.toResponse(save))
                .message("Admin created successfully")
                .status(201)
                .build();
    }

    @Override
    public ApiResponse<List<AdminResponseDto>> getAllAdmins() {
        List<AdminResponseDto> list = adminRepository.findAll().stream().map(mapper::toResponse).toList();
        return ApiResponse.<List<AdminResponseDto>>builder()
                .status(200)
                .data(list)
                .message("All Admins successfully")
                .build();
    }

    @Override
    public ApiResponse<AdminResponseDto> getAdminById(UUID id) {
        AdminEntity adminEntity = adminRepository.findById(id).orElseThrow(() -> {
            log.error("\"admin not found with the id {}",id);
            throw new EntityNotFoundException("admin not found with the id " + id);
        });
        return ApiResponse.<AdminResponseDto>builder()
                .data(mapper.toResponse(adminEntity))
                .message("Admin successfully")
                .status(200)
                .build();
    }

    @Override
    public ApiResponse<Void> deleteAdmin(UUID id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
        }
        log.error("\"admin not found with the id {}", id);
        throw new AdminNotFoundException("admin not found with the id " + id);
    }
}
