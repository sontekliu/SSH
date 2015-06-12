package com.trekiz.hibernate.base;

public interface BaseDao<T> {

	/**
	 * 根据ID查询对象
	 * @param id
	 * @return
	 */
	public T findById(Integer id);
	
	/**
	 * 保存用户对象
	 * @param t
	 * @return
	 */
	public int save(T t);
}
