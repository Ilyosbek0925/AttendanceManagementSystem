package school.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import school.dto.ForgetPasswordDto;
import school.dto.LoginDto;
import school.dto.UsersDto;
import school.dto.requestDto.UserCreateDto;
import school.dto.responseDto.ApiResponse;
import school.enums.Role;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

public interface UserService {
    ResponseEntity<ApiResponse<?>> signUp(UserCreateDto userDto);
    ResponseEntity<ApiResponse<?>>login(LoginDto loginDto);
    UUID getCurrentUserId();
    ResponseEntity<ApiResponse<?>> verifyAccount (String email, Integer code);
    ResponseEntity<ApiResponse<?>>block(UUID userId);
    ResponseEntity<ApiResponse<?>>unBlock(UUID userId);
    ResponseEntity<ApiResponse<?>>setConfirmationCodeForNewPassword(String email);
    ResponseEntity<ApiResponse<?>>checkCodeConfirmationForNewPassword(ForgetPasswordDto forgetPasswordDto);
    ResponseEntity<ApiResponse<?>>setNewPassword(String email, String password);
    ResponseEntity<ApiResponse<?>>dynamicUpdateUserProfile(UUID id, Map<String,Object> updates);
    ResponseEntity<ApiResponse<?>>updateUserRole(UUID id, Role role);
    ResponseEntity<ApiResponse<?>>getProfile(Principal principal);
    ResponseEntity<ApiResponse<Page<UsersDto>>> getAllUsers(Pageable pageable);

}
