package com.tangzhihe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableTransactionManagement  
@MapperScan(basePackages = "com.tangzhihe.dao")
public class SpringBootLoginDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoginDemoApplication.class, args);
	}
}
