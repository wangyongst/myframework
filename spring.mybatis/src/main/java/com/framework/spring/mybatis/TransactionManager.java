package com.framework.spring.mybatis;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

@Configuration
@Order(3)
public class TransactionManager {

	private static final Logger logger = Logger.getLogger(TransactionManager.class);
	
	@Autowired
	@Qualifier("myDS")
	private DataSource dataSource;

	@Bean(name = "myTM")
	public DataSourceTransactionManager transactionManager() {
		logger.info("TransactionManager create!");
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}
}
