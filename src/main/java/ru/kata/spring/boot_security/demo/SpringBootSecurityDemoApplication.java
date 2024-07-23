package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootSecurityDemoApplication implements WebMvcConfigurer {

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/META-INF/resources/", "classpath:/resources/",
			"classpath:/static/", "classpath:/public/"
	};

	public static void main(String[] args) {

		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
//                .addResourceHandler("/resources/**")
//                .addResourceLocations("/resources/");
				.addResourceHandler("/resources/static/**")
				.addResourceLocations("/resources/static/js/");
//                .addResourceLocations("classpath:/static/js/");
	}
}
