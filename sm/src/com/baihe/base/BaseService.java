package com.baihe.base;

import java.util.List;

import com.baihe.utils.dao.Page;

/**
 * 基础Service类，用于定义一些通用的方法
 */
public interface BaseService<T> {

	/**
	 * （开始start，单页大小pageSize）
	 */
	public Page<T> getPage(long start, long pageSize, T t) throws Exception;

	/**
	 * 以主键id获取对象
	 */
	public T get(Object pk) throws Exception;

	/**
	 * 
	 * 返回记录总数
	 */
	public Long getCount() throws Exception;

	/**
	 * 
	 * 返回所有记录
	 */
	public List<T> getAll() throws Exception;

	/**
	 * 
	 * 以对象属性And查询，属性可以是一个或多个,如where a =a and b = b
	 */
	public List<T> findAnd(T t) throws Exception;

	/**
	 * 
	 * 以对象属性Or查询，属性可以是一个或多个,如where a =a or b = b
	 */
	public List<T> findOr(T t) throws Exception;

	/**
	 * 
	 * 以对象属性AndLike查询，属性可以是一个或多个,如where a like '%a%' and b like '%b%'
	 */
	public List<T> findLikeAnd(T t) throws Exception;

	/**
	 * 
	 * 以对象属性OrLike查询，属性可以是一个或多个，如where a like '%a%' or b like '%b%'
	 */
	public List<T> findLikeOr(T t) throws Exception;

	/**
	 * 
	 * 插入单个对象
	 */
	public int insert(T t) throws Exception;

	/**
	 * 
	 * 批量插入对象,T组合成List
	 */
	public int insert(List<T> t) throws Exception;

	/**
	 * 
	 * 更新对象
	 */
	public int update(T t) throws Exception;

	/**
	 * 
	 * 删除单个对象
	 */
	public int delete(Object id) throws Exception;

	/**
	 * 
	 * 批量删除对象，ids组合成List
	 */
	public int delete(List<?> ids) throws Exception;

	/**
	 * 
	 * @return
	 */
	public BaseDao<T> getDao();

}
