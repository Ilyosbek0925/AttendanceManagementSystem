package school.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .version("1.0")
                        .description("API Documentation for Football Pulse")
                        .summary("Football Pulse API Documentation")
                        .title("Football Pulse"));

    }
}
