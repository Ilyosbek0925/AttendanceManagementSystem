package school.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import school.entity.AdminEntity;
import school.entity.UserEntity;
import school.enums.Role;
import school.repository.AdminRepository;
import school.repository.UserRepository;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DataLoaderConfiguration implements CommandLineRunner {
    private final AdminRepository AdminRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;
    @Value("${dataLoader.config}")
    private String dataLoaderStatus;

    @Override
    public void run(String... args) throws Exception {
        if (dataLoaderStatus.equals("always")) {
            AdminEntity admin = new AdminEntity();
            admin.setFirstName("admin");
            admin.setLastName("admin");
            admin.setMail("admin@gmail.com");
            admin.setCode(null);
            admin.setRole(Role.ADMIN);
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setBirthday("1.01.1999");
            admin.setIsEnabled(true);
            admin.setIsAccountNonExpired(true);
            admin.setIsCredentialsNonExpired(true);
            admin.setIsAccountNonLocked(true);
            adminRepository.save(admin);
            log.info("Data loaded successfully");
        }


    }
}


