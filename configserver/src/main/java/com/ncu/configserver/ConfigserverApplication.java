package com.ncu.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ConfigserverApplication.class);
		String configMode = System.getenv("CONFIG_MODE");
		if (configMode != null && configMode.equalsIgnoreCase("native")) {
			app.setAdditionalProfiles("native");
		} else {
			app.setAdditionalProfiles("git");
		}
		app.run(args);
	}

}
