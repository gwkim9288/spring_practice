package com.gwkim.spring.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.gwkim.spring.sample"})
@MapperScan(basePackages = {"com.gwkim.spring.mapper"})
public class RootConfig {
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		//hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		//hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost");
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4fbc:oracle:thin:@localhost:3030:XE");
		
		hikariConfig.setUsername("gwkim");
		hikariConfig.setPassword("gwkim");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource;
	}
	
	//SqlSessionFactory 이용해서 SqlSession을 사용
	@Bean public SqlSessionFactoryBean sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactoryBean)sqlSessionFactory.getObject();
	}
	
}
