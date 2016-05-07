package com.framework.spring.datasource.c3p0;

import java.beans.PropertyVetoException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource({ "classpath:/properties/c3p0.properties" })
@Order(2)
public class C3P0DataSource {
	private static final Logger logger = Logger.getLogger(C3P0DataSource.class);

	@Value("${datasource.driverClass}")
	private String driverClass;
	@Value("${datasource.jdbcUrl}")
	private String jdbcUrl;
	@Value("${datasource.user}")
	private String user;
	@Value("${datasource.password}")
	private String password;
	@Value("${datasource.minPoolSize}")
	private int minPoolSize;
	@Value("${datasource.maxPoolSize}")
	private int maxPoolSize;
	@Value("${datasource.maxIdleTime}")
	private int maxIdleTime;
	@Value("${datasource.acquireIncrement}")
	private int acquireIncrement;
	@Value("${datasource.maxStatements}")
	private int maxStatements;
	@Value("${datasource.initialPoolSize}")
	private int initialPoolSize;
	@Value("${datasource.idleConnectionTestPeriod}")
	private int idleConnectionTestPeriod;
	@Value("${datasource.acquireRetryAttempts}")
	private int acquireRetryAttempts;
	@Value("${datasource.breakAfterAcquireFailure}")
	private boolean breakAfterAcquireFailure;
	@Value("${datasource.testConnectionOnCheckout}")
	private boolean testConnectionOnCheckout;

	/**
	 * 描述 : <负责解析资源文件>. <br>
	 * <p>
	 * <这个类必须有，而且必须声明为static，否则不能正常解析>
	 * </p>
	 * 
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer placehodlerConfigurer() {
		logger.info("PropertySourcesPlaceholderConfigurer create!");
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(name = "myDS")
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		logger.info("DataSource create!");
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setMinPoolSize(minPoolSize);
		dataSource.setMaxPoolSize(maxPoolSize);
		dataSource.setMaxIdleTime(maxIdleTime);
		dataSource.setAcquireIncrement(acquireIncrement);
		dataSource.setMaxStatements(maxStatements);
		dataSource.setInitialPoolSize(initialPoolSize);
		dataSource.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
		dataSource.setAcquireRetryAttempts(acquireRetryAttempts);
		dataSource.setBreakAfterAcquireFailure(breakAfterAcquireFailure);
		dataSource.setTestConnectionOnCheckout(testConnectionOnCheckout);
		return dataSource;
	}
}
