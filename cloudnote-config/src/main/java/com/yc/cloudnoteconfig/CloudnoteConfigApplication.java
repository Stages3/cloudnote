package com.yc.cloudnoteconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudnoteConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudnoteConfigApplication.class, args);
	}

}
