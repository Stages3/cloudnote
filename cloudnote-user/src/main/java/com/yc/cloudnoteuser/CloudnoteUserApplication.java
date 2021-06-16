package com.yc.cloudnoteuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
//开启Redis会话共享
@EnableRedisHttpSession
//自动扫包
@EntityScan("com.yc")
public class CloudnoteUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudnoteUserApplication.class, args);
	}

}
