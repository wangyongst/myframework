package com.framework.persistence.mybatis;

import org.apache.log4j.Logger;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;

import java.io.InputStream;
import java.util.Properties;

@Configuration
@PropertySource({ "classpath:/properties/mybatis.properties" })
@Order(3)
public class MapperScanner {

	private static final Logger logger = Logger.getLogger(MapperScanner.class);

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() throws Exception {
		Properties prop = new Properties();// 属性集合对象   
        InputStream fis = this.getClass().getResourceAsStream("/properties/mybatis.properties");// 属性文件输入流   
        prop.load(fis);// 将属性文件流装载到Properties对象中   
        fis.close();// 关闭流   
		logger.info("MapperScannerConfigurer create!");
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage(prop.getProperty("mybatis.packagesToScan"));
		return mapperScannerConfigurer;
	}
}
