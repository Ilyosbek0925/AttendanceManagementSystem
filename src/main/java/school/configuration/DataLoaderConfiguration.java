package school.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import school.repository.UserRepository;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DataLoaderConfiguration {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${dataLoader.config}")
    private String dataLoaderStatus;
}
