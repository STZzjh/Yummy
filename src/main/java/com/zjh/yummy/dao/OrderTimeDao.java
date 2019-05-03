package com.zjh.yummy.dao;

import com.zjh.yummy.entity.OrderTime;
import com.zjh.yummy.common.db.SimpleQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 订单时间 Mapper 接口
 *
 * @author zjh
 * @since 2019-03-29
 */
@Repository
public interface OrderTimeDao {
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
	 * 查询列表订单时间
	 */
	List<OrderTime> list(SimpleQuery query);
	/*
	 * 统计订单时间
	 */
	int count(SimpleQuery query);
	/*
	 * 查询列表
	 */
	List<OrderTime> listByJoin(SimpleQuery query);
    /*
    * 统计
    */
    int countByJoin(SimpleQuery query);
	/*
	 * 查询一个订单时间
	 */
	OrderTime getById(Integer pkId);

}
