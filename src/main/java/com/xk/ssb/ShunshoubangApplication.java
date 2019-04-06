package com.xk.ssb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xk.ssb.mapperDao")
public class ShunshoubangApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShunshoubangApplication.class, args);
	}

}
