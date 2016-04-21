package com.baihe.utils.dao;

import java.util.List;

/**
 * 分页数据的封装类
 * @author Wangts
 * @since 1.0.0
 */
public class Page<T> {
	
	/**每页的记录数默认值，即每次查询后返回的记录数的默认值*/
	public static final long DEFAULT_PAGE_SIZE = 20;

	/**用于保存查询到的当前页的数据*/
	private List<T> datas;
	
	/**查询到的记录的总数*/
	private long total;
	
	/**返回记录的开始位置，从0开始*/
	private long start;
	
	/**每页的记录数，即每次查询后返回的记录数，默认值为{@link DEFAULT_PAGE_SIZE}*/
	private long pageSize = DEFAULT_PAGE_SIZE;
	
	/**
	 * 通过{@code start}和{@code pageSize}
	 * 计算当前页的页码，页码从1开始
	 * @return 当前页的页码
	 */
	public long getPageNo() {
		this.checkPageSize();
		return (start + pageSize - 1) / pageSize;
	}
	
	/**
	 * 设置当前的页码，些方法的本质是通过{@code pageNoToStart}方法
	 * 将页码转换为{@code start}并设置{@code start}的值
	 * @param pageNo 要设置的页码
	 */
	public void setPageNo(long pageNo) {
		if (pageNo <= 0) pageNo = 1;
		this.setStart(this.pageNoToStart(pageNo));
	}
	
	/**
	 * 私有方法，将{@code pageNo}转换为{@code start}
	 * @param pageNo
	 * @return 转换后的值{@code start}
	 */
	private long pageNoToStart(long pageNo) {
		return (pageNo - 1) * pageSize;
	}
	
	/**
	 * 私有方法，验证{@code pageSize}的值，
	 * 如果小于等于0就设置为{@link DEFAULT_PAGE_SIZE}
	 */
	private void checkPageSize() {
		if (this.pageSize <= 0) this.pageSize = Page.DEFAULT_PAGE_SIZE;
	}
	
	/**
	 * 根据{@code pageSize}和{@code total}计算得出总的页数并返回
	 * @return 总的页数
	 */
	public long getPageCount() {
		this.checkPageSize();
		return (total + pageSize - 1) / pageSize;
	}
	
	/**
	 * 
	 * @return 下一页的页码
	 */
	public long getNextPageNo() {
		long pageNo = this.getPageNo();
		long pageCount = this.getPageCount();
		if (pageNo < pageCount) {
			return pageNo + 1;
		} else {
			return pageCount;
		}
	}
	
	/**
	 * 
	 * @return 前一页的页码
	 */
	public long getPrevPageNo() {
		long pageNo = this.getPageNo();
		if (pageNo > 1) {
			return pageNo - 1;
		} else {
			return 1;
		}
	}

	/**
	 * 
	 * @return 当前页的数据
	 */
	public List<T> getDatas() {
		return datas;
	}

	/**
	 * 
	 * @param datas 查询到的要设置到当前实例的数据
	 */
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	/**
	 * 
	 * @return
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * 
	 * @param total
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * 
	 * @return
	 */
	public long getStart() {
		return start;
	}

	/**
	 * 
	 * @param start
	 */
	public void setStart(long start) {
		if (start < 0) start = 0;
		this.start = start;
	}

	/**
	 * 
	 * @return
	 */
	public long getPageSize() {
		return pageSize;
	}

	/**
	 * 
	 * @param pageSize
	 */
	public void setPageSize(long pageSize) {
		if (pageSize <= 0)
			throw new IllegalArgumentException("pageSize必须大于0");
		this.pageSize = pageSize;
	}
	
	
}
