package com.challenge.streamingvideos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Swagger OpenApi",
				version = "1",
				description = "TechChallange-1ADJT-parquimetro"
		)
)
public class StreamingVideosApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamingVideosApplication.class, args);
	}

}
