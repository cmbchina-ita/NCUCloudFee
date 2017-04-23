package io.renren;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan("io.renren.dao")
@ComponentScan( basePackages = { "io.renren", "ies.ncu.edu.cn" })
@MapperScan( basePackages = { "io.renren.dao", "ies.ncu.edu.cn.dao" })
public class RenrenApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenrenApplication.class, args);
	}
}
