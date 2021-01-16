package com.gwkim.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.gwkim.spring.sample"})
public class RootConfig {
	@Bean
	public Datasource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost");
		hikariConfig.setUsername("gwkim");
		hikariConfig.setPassword("gwkim");
		
		HikariDataSource dataSource = new HikaridataSource(hikariConfig);
		
		return dataSource;
	}
}
