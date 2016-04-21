package com.baihe.base;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.baihe.controller", "com.baihe.service" })
// 启用注解事务管理，使用CGLib代理
@EnableTransactionManagement(proxyTargetClass = true)
@Order(2)
public class SpringConfig extends WebMvcConfigurerAdapter {

	private static final Logger logger = Logger.getLogger(SpringConfig.class);
	
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
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sm?useUnicode=true&characterEncoding=UTF8&useOldAliasMetadataBehavior=true&zeroDateTimeBehavior=convertToNull");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setIdleConnectionTestPeriod(2);
		dataSource.setIdleMaxAge(2);
		dataSource.setMaxConnectionsPerPartition(6);
		dataSource.setMinConnectionsPerPartition(2);
		dataSource.setPartitionCount(20);
		dataSource.setStatementsCacheSize(10000);
		dataSource.setReleaseHelperThreads(4);
		return dataSource;
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean SqlSessionFactoryBean() throws Exception {
		logger.info("sessionFactory");
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setTypeAliasesPackage("com.baihe.pojo");
		org.springframework.core.io.Resource configLocation = new DefaultResourceLoader()
				.getResource("classpath:properties/mybatis-config.xml");
		sessionFactory.setConfigLocation(configLocation);
		return sessionFactory;

	}

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager transactionManager() {
		logger.info("transactionManager");
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

	@Bean
	public ViewResolver viewResolver() {
		logger.info("ViewResolver");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		logger.info("MapperScannerConfigurer");
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.baihe.dao");
		return mapperScannerConfigurer;
	}
}
