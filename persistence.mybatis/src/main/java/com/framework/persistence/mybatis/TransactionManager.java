package com.framework.persistence.mybatis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@Order(3)
public class TransactionManager {

	private static final Logger logger = LogManager.getLogger(TransactionManager.class);
	
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
