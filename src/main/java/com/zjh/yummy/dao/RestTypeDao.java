package com.zjh.yummy.dao;

import com.zjh.yummy.entity.RestType;
import com.zjh.yummy.common.db.SimpleQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 餐厅类型 Mapper 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
@Repository
public interface RestTypeDao {
    /*
	 * 添加餐厅类型
	 */
	int insert(RestType restType);
	/*
	 * 删除餐厅类型
	 */
	int delete(int pkid);
	/*
	 * 修改餐厅类型
	 */
	int update(RestType restType);
	/*
	 * 查询列表餐厅类型
	 */
	List<RestType> list(SimpleQuery query);
	/*
	 * 统计餐厅类型
	 */
	int count(SimpleQuery query);
	/*
	 * 查询列表
	 */
	List<RestType> listByJoin(SimpleQuery query);
    /*
    * 统计
    */
    int countByJoin(SimpleQuery query);
	/*
	 * 查询一个餐厅类型
	 */
	RestType getById(Integer pkId);

}
