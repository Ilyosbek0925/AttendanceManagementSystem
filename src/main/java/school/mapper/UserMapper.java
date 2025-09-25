package school.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import school.dto.requestDto.UserCreateDto;
import school.entity.UserEntity;
import school.enums.Role;
import school.exception.NotAcceptableException;
import school.repository.UserRepository;
@Component
@RequiredArgsConstructor
public class UserMapper {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public UserEntity toEntity(UserCreateDto userCreateDto, Integer code) {
        return UserEntity.builder()
                .firstName(userCreateDto.getFirstName())
                .lastName(userCreateDto.getLastName())
                .birthday(userCreateDto.getBirthday())
                .role(Role.User)
                .imageUrl(userCreateDto.getImageUrl())
                .password(passwordEncoder.encode(userCreateDto.getPassword()))
                .mail(userCreateDto.getMail())
                .code(code)
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .build();
    }


    public UserCreateDto getProfile(String mail){
        UserEntity user = userRepository.findByMail(mail).orElseThrow(() -> new NotAcceptableException("User not found"));
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setFirstName(user.getFirstName());
        userCreateDto.setLastName(user.getLastName());
        userCreateDto.setBirthday(user.getBirthday());
        userCreateDto.setImageUrl(user.getImageUrl());
        userCreateDto.setUsername(user.getUsername());
        userCreateDto.setMail(user.getMail());
        return userCreateDto;
    }
}
