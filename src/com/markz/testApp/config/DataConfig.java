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
		String url = "jdbc:mysql://<serverURL>:3306/<databse>";
		String username = "user";
		String password = "passwd";
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
