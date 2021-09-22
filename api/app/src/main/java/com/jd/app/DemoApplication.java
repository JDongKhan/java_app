package com.jd.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages={"com.jd.app","com.jd.core","com.jd.dao"})
@ServletComponentScan(basePackages = "com.jd.*")
@MapperScan(basePackages = "com.jd.dao.mapper")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
