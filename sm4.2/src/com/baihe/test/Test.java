package com.baihe.test;

import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	
	 public static void main(String[] args) {  
	        ApplicationContext annotationContext = new AnnotationConfigApplicationContext("com.baihe.test");  
	        DefaultSqlSessionFactory SpringConfig = annotationContext.getBean("sqlSessionFactory", DefaultSqlSessionFactory.class);// 创建bean的引用对象  
	        System.out.println(SpringConfig.toString()); 
	       
	    } 
}
