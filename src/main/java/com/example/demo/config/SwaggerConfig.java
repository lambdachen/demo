package com.example.demo.config;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableSwagger2Doc
@Profile("!Test")
public class SwaggerConfig {
}
