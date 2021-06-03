package com.yc.cloudnoteeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudnoteEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudnoteEurekaApplication.class, args);
	}

}
