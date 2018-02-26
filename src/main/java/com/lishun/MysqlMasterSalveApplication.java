package com.lishun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.lishun.mapper") //!!!!!! 注意:扫描所有mapper
public class MysqlMasterSalveApplication {
	public static void main(String[] args) {
		SpringApplication.run(MysqlMasterSalveApplication.class, args);
	}
}
