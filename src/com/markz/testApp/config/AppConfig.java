package com.markz.testApp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.markz.testApp")
@EnableWebMvc
public class AppConfig {
	
}
