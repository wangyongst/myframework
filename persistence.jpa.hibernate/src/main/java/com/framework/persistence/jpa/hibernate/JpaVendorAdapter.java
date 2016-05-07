package com.framework.persistence.jpa.hibernate;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource({ "classpath:/properties/jpa.properties" })
@Order(3)
public class JpaVendorAdapter {

	private static final Logger logger = Logger
			.getLogger(JpaVendorAdapter.class);

	@Value("${jpa.generateDdl}")
	private boolean generateDdl;
	@Value("${jpa.databasePlatform}")
	private String databasePlatform;
	@Value("${jpa.showSql}")
	private boolean showSql;

	
	@Bean(name = "myJVA")
	public HibernateJpaVendorAdapter jpaVendorAdapter() throws Exception {
		logger.info("JpaVendorAdapter create!");
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(generateDdl);
		jpaVendorAdapter.setDatabasePlatform(databasePlatform);
		jpaVendorAdapter.setShowSql(showSql);
		return jpaVendorAdapter;

	}
}
