package com.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer; // 1. import 추가

@SpringBootApplication
public class SpringbootApplication extends SpringBootServletInitializer { // 2. 'extends' 추가

	@Override // 3. configure 메소드 추가
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootApplication.class);
	}

	public static void main(String[] args) {
		// 이 main 메소드는 JAR로 실행할 때를 위해 그대로 둡니다.
		SpringApplication.run(SpringbootApplication.class, args);
	}

}