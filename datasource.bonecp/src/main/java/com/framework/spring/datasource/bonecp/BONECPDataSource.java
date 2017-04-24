package com.framework.spring.datasource.bonecp;

import com.jolbox.bonecp.BoneCPDataSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;

import java.beans.PropertyVetoException;

@Configuration
@PropertySource({"classpath:/properties/bonecp.properties"})
@Order(2)
public class BONECPDataSource {
	private static final Logger logger = LogManager.getLogger(BONECPDataSource.class);

	@Value("${datasource.driverClass}")
	private String driverClass;
	@Value("${datasource.jdbcUrl}")
	private String jdbcUrl;
	@Value("${datasource.user}")
	private String user;
	@Value("${datasource.password}")
	private String password;
	@Value("${datasource.partitionCount}")
	private int patitionCount;
	@Value("${datasource.minConnectionsPerPartition}")
	private int minConnectionsPerPartition;
	@Value("${datasource.maxConnectionsPerPartition}")
	private int maxConnectionsPerPartition;
	@Value("${datasource.acquireIncrement}")
	private int acquireIncrement;
	@Value("${datasource.idleMaxAgeInMinutes}")
	private long idleMaxAgeInMinutes;
	@Value("${datasource.statementsCacheSize}")
	private int statementsCacheSize;
	@Value("${datasource.idleConnectionTestPeriodInMinutes}")
	private long idleConnectionTestPeriodInMinutes;

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
	public BoneCPDataSource dataSource() throws PropertyVetoException {
		logger.info("DataSource create!");
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setPartitionCount(patitionCount);
		dataSource.setMinConnectionsPerPartition(minConnectionsPerPartition);
		dataSource.setMaxConnectionsPerPartition(maxConnectionsPerPartition);
		dataSource.setAcquireIncrement(acquireIncrement);
		dataSource.setIdleMaxAgeInMinutes(idleMaxAgeInMinutes);
		dataSource.setStatementsCacheSize(statementsCacheSize);
		dataSource.setIdleConnectionTestPeriodInMinutes(idleConnectionTestPeriodInMinutes);
		return dataSource;
	}
}
