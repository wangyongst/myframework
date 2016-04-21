package com.framework.spring.mybatis;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.DefaultResourceLoader;

@Configuration
@Order(3)
public class SessionFactory {

	private static final Logger logger = Logger.getLogger(SessionFactory.class);

	@Autowired
	@Qualifier("myDS")
	private DataSource dataSource;

	@Bean(name = "mySF")
	public SqlSessionFactoryBean SqlSessionFactoryBean() throws Exception {
		logger.info("SessionFactory create!");
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		org.springframework.core.io.Resource configLocation = new DefaultResourceLoader()
				.getResource("classpath:properties/mybatis-config.xml");
		sessionFactory.setConfigLocation(configLocation);
		return sessionFactory;

	}
}
