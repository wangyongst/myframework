package com.framework.persistence.jpa.hibernate;

import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
@PropertySource({ "classpath:/properties/jpa.properties" })
@EnableJpaRepositories(basePackages="com.myweb.repository",repositoryImplementationPostfix="Impl",entityManagerFactoryRef="myEMF",transactionManagerRef="myTM")
@Order(3)
public class TransactionManager {

	private static final Logger logger = Logger
			.getLogger(TransactionManager.class);
	@Autowired
	@Qualifier("myEMF")
	private EntityManagerFactory entityManagerFactory;

	@Bean(name = "myTM")
	public JpaTransactionManager transactionManager() {
		logger.info("TransactionManager create!");
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
