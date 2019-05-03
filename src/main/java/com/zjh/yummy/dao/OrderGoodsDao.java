package com.zjh.yummy.dao;

import com.zjh.yummy.entity.OrderGoods;
import com.zjh.yummy.common.db.SimpleQuery;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单表 Mapper 接口
 *
 * @author zjh
 * @since 2019-03-29
 */
@Repository
public interface OrderGoodsDao {
    /*
	 * 添加订单表
	 */
	int insert(OrderGoods orderGoods);
	/*
	 * 删除订单表
	 */
	int delete(int pkid);
	/*
	 * 修改订单表
	 */
	int update(OrderGoods orderGoods);
	/*
	 * 查询列表订单表
	 */
	List<OrderGoods> list(SimpleQuery query);
	/*
	 * 统计订单表
	 */
	int count(SimpleQuery query);
	/*
	 * 查询列表
	 */
	List<OrderGoods> listByJoin(SimpleQuery query);
    /*
    * 统计
    */
    int countByJoin(SimpleQuery query);
	/*
	 * 查询一个订单表
	 */
	OrderGoods getById(Integer pkId);

	List<OrderGoods> restaurantCount(SimpleQuery query);

	List<OrderGoods> userCount(SimpleQuery query);

	BigDecimal adminCount(SimpleQuery query);

}
