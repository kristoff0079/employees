package com.kristoff.employees.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@Configuration
public class SecuityConfig {
}
