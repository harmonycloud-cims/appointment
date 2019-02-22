package com.harmonycloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableSwagger2
@ComponentScan("com.harmonycloud")
@EnableJpaRepositories("com.harmonycloud.repository")
@EntityScan("com.harmonycloud.entity")
public class AppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentApplication.class, args);
	}

}

