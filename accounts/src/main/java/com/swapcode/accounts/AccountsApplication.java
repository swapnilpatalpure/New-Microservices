package com.swapcode.accounts;

import com.swapcode.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Account microservice REST API documentation",
				description = "SwapCode Account microservices REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Swapnil",
						email = "swapnil@gmail.com",
						url = "http://www.wazybytes.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.wazybytes.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "SwapCode Account microservices REST API Documentation",
				url = "http://www.wazybytes.com"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
