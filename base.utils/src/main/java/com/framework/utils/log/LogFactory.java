package com.framework.utils.log;


import java.util.Arrays;
import java.util.List;

import com.framework.utils.ClassUtil;
import com.framework.utils.log.dialect.ApacheCommonsLog;
import com.framework.utils.log.dialect.JdkLog;
import com.framework.utils.log.dialect.Log4j2Log;
import com.framework.utils.log.dialect.Log4jLog;
import com.framework.utils.log.dialect.Slf4jLog;

public class LogFactory {
	
	private static final Class<? extends AbstractLog> currentLogClass = detectLog();
	
	public static Class<? extends AbstractLog> detectLog(){
		@SuppressWarnings("unchecked")
		List<Class<? extends AbstractLog>> logClassList = Arrays.asList(
				Slf4jLog.class,
				Log4jLog.class, 
				Log4j2Log.class, 
				ApacheCommonsLog.class, 
				JdkLog.class
		);
		
		for (Class<? extends AbstractLog> clazz : logClassList) {
			try {
				clazz.getConstructor(Class.class).newInstance(LogFactory.class).info("Use Log Framework: [{}]", clazz.getSimpleName());
				return clazz;
			} catch ( Exception e) {
				continue;
			}
		}
		return JdkLog.class;
	}
	
	public static Class<? extends AbstractLog> getCurrentLogClass(){
		return currentLogClass;
	}
	
	public static Log getLog(String name){
		return ClassUtil.newInstance(currentLogClass, name);
	}
	
	public static Log getLog(Class<?> clazz){
		return ClassUtil.newInstance(currentLogClass, clazz);
	}
	
	public static Log get() {
		return getLog(new Exception().getStackTrace()[1].getClassName());
	}
	
	protected static Log indirectGet() {
		return getLog(new Exception().getStackTrace()[2].getClassName());
	}
}
