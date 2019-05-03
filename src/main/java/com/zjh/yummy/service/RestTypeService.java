package com.zjh.yummy.service;

import java.util.List;
import com.zjh.yummy.entity.RestType;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;

/**
 *
 * 餐厅类型 Service 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
public interface RestTypeService {
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
	 * 最多1000条餐厅类型
	 */
	List<RestType> findList(SimpleQuery query);
	/*
	 * 分页餐厅类型
	 */
	BTableData page(SimpleQuery query);

	BTableData pageByJoin(SimpleQuery query);
	/*
	 * 查询一个餐厅类型
	 */
	RestType getById(Integer pkId);

}
