package com.zjh.yummy.dao;

import com.zjh.yummy.entity.Restaurant;
import com.zjh.yummy.common.db.SimpleQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 餐馆 Mapper 接口
 *
 * @author zjh
 * @since 2019-03-29
 */
@Repository
public interface RestaurantDao {
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
	 * 查询列表餐馆
	 */
	List<Restaurant> list(SimpleQuery query);
	/*
	 * 统计餐馆
	 */
	int count(SimpleQuery query);
	/*
	 * 查询列表
	 */
	List<Restaurant> listByJoin(SimpleQuery query);
    /*
    * 统计
    */
    int countByJoin(SimpleQuery query);
	/*
	 * 查询一个餐馆
	 */
	Restaurant getById(Integer pkId);

}
