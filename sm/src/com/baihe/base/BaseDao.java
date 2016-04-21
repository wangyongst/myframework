package com.baihe.base;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao类，用于定义一些通用的方法
 */
public interface BaseDao<T> {

	/**
	 * 分页查询 map封装两个分页参数，（开始start，单页大小pageSize）
	 * 
	 */
	public List<T> getPage(Map<String, Object> param) throws Exception;

	/**
	 * 返回记录总数
	 * 
	 */
	public long getCount() throws Exception;

	/**
	 * 根据id查询对象
	 * 
	 */
	public T get(Object id) throws Exception;

	/**
	 * 返回所有记录
	 * 
	 */
	public List<T> getAll() throws Exception;

	/**
	 * 根据属性Or查询，可以是一个或多个属性
	 * 
	 */
	public List<T> findOr(T t) throws Exception;

	/**
	 * 根据属性And查询，可以是一个或多个属性
	 * 
	 */
	public List<T> findAnd(T t) throws Exception;

	/**
	 * 根据属性LikeOr查询，可以是一个或多个属性
	 * 
	 */
	public List<T> findLikeOr(T t) throws Exception;

	/**
	 * 根据属性LikeAnd查询，可以是一个或多个属性
	 * 
	 */
	public List<T> findLikeAnd(T t) throws Exception;

	/**
	 * 插入记录
	 * 
	 */
	public int insert(List<T> t) throws Exception;

	/**
	 * 更新对象
	 * 
	 */
	public int update(T t) throws Exception;

	/**
	 * 删除对象,ids为List,可批量操作
	 * 
	 */
	public int delete(List<?> ids) throws Exception;
}
