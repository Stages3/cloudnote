package com.yc.cloudnotezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy    //开启路由
public class CloudnoteZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudnoteZuulApplication.class, args);
	}

}
