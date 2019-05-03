package com.zjh.yummy.service;

import java.util.List;
import com.zjh.yummy.entity.OrderTime;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;

/**
 *
 * 订单时间 Service 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
public interface OrderTimeService {
    /*
	 * 添加订单时间
	 */
	int insert(OrderTime orderTime);
	/*
	 * 删除订单时间
	 */
	int delete(int pkid);
	/*
	 * 修改订单时间
	 */
	int update(OrderTime orderTime);

	/*
	 * 最多1000条订单时间
	 */
	List<OrderTime> findList(SimpleQuery query);
	/*
	 * 分页订单时间
	 */
	BTableData page(SimpleQuery query);

	BTableData pageByJoin(SimpleQuery query);
	/*
	 * 查询一个订单时间
	 */
	OrderTime getById(Integer pkId);

}
