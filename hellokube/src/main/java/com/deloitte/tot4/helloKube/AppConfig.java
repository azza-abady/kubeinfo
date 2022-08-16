package com.deloitte.tot4.helloKube;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("users")
public class AppConfig {

    private String name;
}
