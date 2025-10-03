package school.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import school.dto.requestDto.AdminRequestDto;
import school.dto.responseDto.AdminResponseDto;
import school.entity.AdminEntity;

@RequiredArgsConstructor
@Component
public class AdminMapper {
    private final PasswordEncoder passwordEncoder;
    public AdminResponseDto toResponse(AdminEntity admin) {
        return AdminResponseDto.builder()
                .id(admin.getId())
                .mail(admin.getMail())
                .birthday(admin.getBirthday())
                .role(admin.getRole())
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .build();
    }

    public AdminEntity toAdmin(AdminRequestDto requestDto) {
        AdminEntity admin = new AdminEntity();
        admin.setMail(requestDto.getMail());
        admin.setFirstName(requestDto.getFirstName());
        admin.setLastName(requestDto.getLastName());
        admin.setRole(requestDto.getRole());
        admin.setBirthday(requestDto.getBirthday());
        admin.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        return admin;
    }

}
