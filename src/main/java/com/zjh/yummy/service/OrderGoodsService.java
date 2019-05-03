package com.zjh.yummy.service;

import java.util.List;
import com.zjh.yummy.entity.OrderGoods;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;

/**
 *
 * 订单表 Service 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
public interface OrderGoodsService {
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
	 * 最多1000条订单表
	 */
	List<OrderGoods> findList(SimpleQuery query);
	/*
	 * 分页订单表
	 */
	BTableData page(SimpleQuery query);

	BTableData pageByJoin(SimpleQuery query);
	/*
	 * 查询一个订单表
	 */
	OrderGoods getById(Integer pkId);


	List<OrderGoods> restaurantCount(SimpleQuery query);

	List<OrderGoods> userCount(SimpleQuery query);

	OrderGoods adminCount(SimpleQuery query);

}
