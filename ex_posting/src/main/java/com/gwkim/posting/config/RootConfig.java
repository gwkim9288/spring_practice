package com.gwkim.posting.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan("com.gwkim.posting.mapper")
@ComponentScan("com.gwkim.posting.service")
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/schema?useSSL=false&amp;serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("19m28b37!");
		
//		HikariConfig hikariConfig = new HikariConfig();
//		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
//		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:3030:XE");
//		
//		hikariConfig.setUsername("gwkim");
//		hikariConfig.setPassword("gwkim");
		
		
		//HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource;
	}
	
	//SqlSessionFactory �̿��ؼ� SqlSession�� ���
	@Bean public SqlSessionFactoryBean sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactoryBean)sqlSessionFactory.getObject();
	}

}
