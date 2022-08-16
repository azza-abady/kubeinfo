package com.deloitte.tot.hellokubeuser;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Data
@Configuration
@ConfigurationProperties("endpoint")
public class AppConfig {
    private String url;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
