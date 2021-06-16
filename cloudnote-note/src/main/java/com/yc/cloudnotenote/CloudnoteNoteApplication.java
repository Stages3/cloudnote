package com.yc.cloudnotenote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//实体类扫描
@EntityScan("com.yc")
//设置映射器包扫描
@MapperScan("com.yc.cloudnotenote.dao")
public class CloudnoteNoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudnoteNoteApplication.class, args);
	}

}
