package com.baihe.base;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource({ "classpath:/properties/jdbc.properties",
		"classpath:/properties/bonecp.properties" })
@Order(2)
public class DataSourceConfig {
	private static final Logger logger = Logger
			.getLogger(DataSourceConfig.class);
	/*
	 * 绑定资源属性
	 */
	@Value("${jdbc.driverClassName}")
	String driverClass;
	@Value("${jdbc.url}")
	String jdbcUrl;
	@Value("${jdbc.username}")
	String userName;
	@Value("${jdbc.password}")
	String passWord;
	@Value("${bonecp.idleConnectionTestPeriod}")
	long idleConnectionTestPeriod;
	@Value("${bonecp.idleMaxAge}")
	long idleMaxAge;
	@Value("${bonecp.maxConnectionsPerPartition}")
	int maxConnectionsPerPartition;
	@Value("${bonecp.minConnectionsPerPartition}")
	int minConnectionsPerPartition;
	@Value("${bonecp.partitionCount}")
	int partitionCount;
	@Value("${bonecp.statementsCacheSize}")
	int statementsCacheSize;
	@Value("${bonecp.releaseHelperThreads}")
	int releaseHelperThreads;

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
		logger.info("PropertySourcesPlaceholderConfigurer");
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		logger.info("DataSource");
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUsername(userName);
		dataSource.setPassword(passWord);
		dataSource.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
		dataSource.setIdleMaxAge(idleMaxAge);
		dataSource.setMaxConnectionsPerPartition(maxConnectionsPerPartition);
		dataSource.setMinConnectionsPerPartition(minConnectionsPerPartition);
		dataSource.setPartitionCount(partitionCount);
		dataSource.setStatementsCacheSize(statementsCacheSize);
		dataSource.setReleaseHelperThreads(releaseHelperThreads);
		return dataSource;
	}
}