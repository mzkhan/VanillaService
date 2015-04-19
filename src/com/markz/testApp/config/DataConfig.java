package com.markz.testApp.config;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@MapperScan("com.markz.testApp.mappers")
public class DataConfig {

	@Bean
	public DataSource dataSource() {
		String driverClass = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://enliteinstance.c9a1yjg7i5cn.us-east-1.rds.amazonaws.com:3306/test";
		String username = "master";
		String password = "enliteUs";
		PooledDataSource dataSource = new PooledDataSource(driverClass, url, username, password);
//		dataSource.setPoolMaximumActiveConnections(20);		
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setTypeAliasesPackage("com.markz.testApp.objects");
		
		return sessionFactory.getObject();
	}

}
