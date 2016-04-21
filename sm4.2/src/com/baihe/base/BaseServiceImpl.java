package com.baihe.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baihe.utils.dao.Page;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Override
	public Page<T> getPage(long start, long pageSize, T t)
			throws ServiceException {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			Page<T> page = new Page<T>();
			long total = this.getMapper().getCount();
			while (start >= total && start > 0) {
				start -= pageSize;
			}
			page.setTotal(total);
			page.setStart(start);
			page.setPageSize(pageSize);

			params.put("start", start);
			params.put("pageSize", pageSize);
			List<T> list = this.getMapper().getPage(params);
			page.setDatas(list);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("分页查询数据时出现异常", e);
		}
	}

	@Override
	public T get(Object pk) throws ServiceException {
		try {
			return this.getMapper().get(pk);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Get数据时出现异常", e);
		}
	}

	@Override
	public List<T> getAll() throws Exception {
		try {
			return this.getMapper().getAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("GetAll查询数据时出现异常！", e);
		}
	}

	@Override
	public int insert(List<T> t) throws Exception {
		try {
			return this.getMapper().insert(t);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("插入数据时出现异常！", e);
		}
	}

	@Override
	public int update(T t) throws Exception {
		try {
			return this.getMapper().update(t);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("更新数据时出现异常！", e);
		}
	}

	@Override
	public int delete(List<?> ids) throws Exception {
		try {
			return this.getMapper().delete(ids);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("删除数据时出现异常！", e);
		}
	}

	@Override
	public List<T> findAnd(T t) throws Exception {
		try {
			return this.getMapper().findAnd(t);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("FindAnd查询数据时出现异常！", e);
		}
	}

	@Override
	public List<T> findOr(T t) throws Exception {
		try {
			return this.getMapper().findOr(t);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("FindOr查询数据时出现异常！", e);
		}
	}

	@Override
	public List<T> findLikeAnd(T t) throws Exception {
		try {
			return this.getMapper().findLikeAnd(t);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("FindLikeAnd查询数据时出现异常！", e);
		}
	}

	@Override
	public List<T> findLikeOr(T t) throws Exception {
		try {
			return this.getMapper().findLikeOr(t);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("FindLikeOr查询数据时出现异常！", e);
		}
	}

	@Override
	public Long getCount() throws Exception {
		try {
			return this.getMapper().getCount();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("GetCount查询数据时出现异常！", e);
		}
	}

	@Override
	public int insert(T t) throws Exception {
		List<T> list = new ArrayList();
		list.add(t);
		return this.getMapper().insert(list);

	}

	@Override
	public int delete(Object id) throws Exception {
		List<Object> list = new ArrayList();
		list.add(id);
		return this.getMapper().delete(list);
	}

}
