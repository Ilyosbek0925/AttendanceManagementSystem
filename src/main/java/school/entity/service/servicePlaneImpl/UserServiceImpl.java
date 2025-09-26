package school.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.dto.ForgetPasswordDto;
import school.dto.LoginDto;
import school.dto.UsersDto;
import school.dto.requestDto.UserCreateDto;
import school.dto.responseDto.ApiResponse;
import school.dto.responseDto.JwtResponse;
import school.entity.UserEntity;
import school.enums.Role;
import school.exception.DataNotFoundException;
import school.exception.NotAcceptableException;
import school.jwt.JwtTokenService;
import school.mapper.UserMapper;
import school.repository.UserRepository;
import school.service.EmailService;
import school.service.UserService;

import java.security.Principal;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EmailService emailService;
    private final JwtTokenService jwtTokenService;
    private final PasswordEncoder passwordEncoder;



    @Override
    public ResponseEntity<ApiResponse<?>> signUp(UserCreateDto userDto) {
        if (userRepository.existsByMail(userDto.getMail()))
            throw new NotAcceptableException("User already exists");
        int code = new Random().nextInt(1000, 9000);
        emailService.sendVerificationCode(userDto.getFirstName(), userDto.getMail(), code);
        userRepository.save(userMapper.toEntity(userDto, code));
        log.info("User successfully created to '{}'", userDto.getUsername());
        return ResponseEntity.ok(ApiResponse.builder().message("User successfully created").status(200).data(null).build());
    }


    @Override
    public ResponseEntity<ApiResponse<?>> login(LoginDto loginDto) {
        UserEntity user = userRepository.findByMail(loginDto.getMail()).orElseThrow(() -> new DataNotFoundException("User not found"));
        if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            if (user.getIsEnabled()) {
                return ResponseEntity.ok(ApiResponse.builder()
                        .data(JwtResponse.builder().token(jwtTokenService.generateAccessToken(user)).build())
                        .message("Login in system")
                        .status(200)
                        .build());
            }
            throw new NotAcceptableException("Your account has blocked");
        }
        throw new NotAcceptableException("Your password is incorrect or you are not signed in");
    }

    @Override
    public ResponseEntity<ApiResponse<?>> verifyAccount(String email, Integer code) {
        UserEntity user = userRepository.findByMailAndCode(email, code).orElseThrow(() -> new DataNotFoundException("User not found"));
        user.setCode(null);
        return ResponseEntity.ok(ApiResponse.builder().status(200).message("User successfully verified").data(jwtTokenService.generateAccessToken(userRepository.save(user))).build());
    }


    @Override
    @Transactional(readOnly = true)
    // Helper method to get the current user ID from a security context
    public UUID getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Get the email from authentication (UserEntity.getUsername() returns email)
        String email = authentication.getName();

        // Find a user by email and return their UUID
        Optional<UserEntity> user = userRepository.findByMail(email);
        if (user.isEmpty()) {
            throw new DataNotFoundException("User not found with email: " + email);
        }
        return user.get().getId();
    }

    @Override
    public ResponseEntity<ApiResponse<?>> block(UUID userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new DataNotFoundException("User not found"));
        user.setIsEnabled(false);
        emailService.sendUnBlockOrBlockMessage(user.getMail(), false);
        userRepository.save(user);
        return ResponseEntity.ok(ApiResponse.builder().status(200).message("User successfully blocked").data(null).build());
    }

    @Override
    public ResponseEntity<ApiResponse<?>> unBlock(UUID userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new DataNotFoundException("User not found"));
        user.setIsEnabled(true);
        emailService.sendUnBlockOrBlockMessage(user.getMail(), true);
        userRepository.save(user);
        return ResponseEntity.ok(ApiResponse.builder().status(200).message("User successfully unblocked").data(null).build());
    }


    //Stage-1 Sent code
    @Override
    public ResponseEntity<ApiResponse<?>> setConfirmationCodeForNewPassword(String email) {
        UserEntity user = userRepository.findByMail(email).orElseThrow(() -> new DataNotFoundException("User not found"));
        int code = new Random().nextInt(1000, 9000);
        user.setCode(code);

        emailService.sendForgetPasswordConfirmationCode(user.getMail(), code);
        userRepository.save(user);
        return ResponseEntity.ok(ApiResponse.builder().data(null).message("We sent confirmation code, please check your mail address").status(200).build());
    }



    //Stage-2 Check code
    @Override
    public ResponseEntity<ApiResponse<?>> checkCodeConfirmationForNewPassword(ForgetPasswordDto forgetPasswordDto) {
        userRepository.findByMailAndCode(forgetPasswordDto.getMail(), forgetPasswordDto.getCode()).orElseThrow(() ->
                new NotAcceptableException("Your code is wrong, please try again!"));
        return ResponseEntity.ok(ApiResponse.builder().data(null).message("code checked!").status(200).build());
    }

    //Stage-3 Set new Password
    @Override
    public ResponseEntity<ApiResponse<?>> setNewPassword(String email, String password) {
        UserEntity user = userRepository.findByMail(email).orElseThrow(() -> new DataNotFoundException("User not found"));
        if (passwordEncoder.matches(password, user.getPassword())) {
            throw new NotAcceptableException("Your password are the same as the your old password, please try again and create a new password");
        } else {
            user.setCode(null);
            user.setPassword(passwordEncoder.encode(password));
            emailService.sendMessageAboutPasswordChanged(user.getMail());
            userRepository.save(user);
        }
        return ResponseEntity.ok(ApiResponse.builder().data(null).status(200).message("Password updated congratulations").build());
    }

    @Override
    public ResponseEntity<ApiResponse<?>> dynamicUpdateUserProfile(UUID id, Map<String, Object> updates) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "email":
                    user.setMail((String) value);
                    log.info("User {}: updated email to '{}'", id, value);
                    break;
                case "firstName":
                    user.setFirstName((String) value);
                    log.info("User {}: updated firstName to '{}'", id, value);
                    break;
                case "lastName":
                    user.setLastName((String) value);
                    log.info("User {}: updated lastName to '{}'", id, value);
                    break;
                case "birthday":
                    user.setBirthday((String) value);
                    log.info("User {}: updated birthday to '{}'", id, value);
                    break;

                case "imageUrl":
                    user.setImageUrl((String) value);
                    log.info("User {}: updated image to '{}'", id, value);
                    break;

                case "password":
                    log.info("User {}: updated password to '{}'", id, value);
                    user.setPassword(passwordEncoder.encode((String) value));
                    break;
                case "mail":
                    user.setMail((String) value);
                    log.info("User {}: updated mail to '{}'", id, value);
                    break;

                default:
                    throw new IllegalArgumentException("Field '" + key + "' is not allowed to update");
            }
        });

        userRepository.save(user);
        return ResponseEntity.ok(ApiResponse.builder().data(null).message("User profile updated").status(200).build());
    }

    @Override
    public ResponseEntity<ApiResponse<?>> updateUserRole(UUID id, Role role) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));
        user.setRole(role);
        userRepository.save(user);
        return ResponseEntity.ok(ApiResponse.builder().data(null).message("User role updated").status(200).build());
    }

    @Override
    public ResponseEntity<ApiResponse<?>> getProfile(Principal principal) {
        return ResponseEntity.ok(ApiResponse.builder().data(userMapper.getProfile(principal.getName())).status(200).build());
    }

    @Override
    public ResponseEntity<ApiResponse<Page<UsersDto>>> getAllUsers(Pageable pageable) {
        Page<UserEntity> allUsers = userRepository.findAll(pageable);
        Page<UsersDto> users= allUsers.map(userEntity -> new UsersDto(
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getMail(),
                userEntity.getBirthday(),
                userEntity.getUsername(),
                userEntity.getRole())
        );
        return ResponseEntity.ok(ApiResponse.<Page<UsersDto>>builder().status(200).data(users).message("all users").build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByMail(username).orElseThrow(() -> new DataNotFoundException("User not found"));
    }
}
