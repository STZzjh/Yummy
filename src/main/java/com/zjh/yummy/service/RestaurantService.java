package com.zjh.yummy.service;

import java.util.List;

import com.zjh.yummy.entity.Admin;
import com.zjh.yummy.entity.Restaurant;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;

/**
 *
 * 餐馆 Service 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
public interface RestaurantService {
    /*
	 * 添加餐馆
	 */
	int insert(Restaurant restaurant);
	/*
	 * 删除餐馆
	 */
	int delete(int pkid);
	/*
	 * 修改餐馆
	 */
	int update(Restaurant restaurant);

	/*
	 * 最多1000条餐馆
	 */
	List<Restaurant> findList(SimpleQuery query);
	/*
	 * 分页餐馆
	 */
	BTableData page(SimpleQuery query);

	BTableData pageByJoin(SimpleQuery query);
	/*
	 * 查询一个餐馆
	 */
	Restaurant getById(Integer pkId);

    Restaurant login(String username);
}
