package com.zjh.yummy.service.impl;

import java.math.BigDecimal;
import java.util.List;
import com.zjh.yummy.entity.OrderGoods;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.service.OrderGoodsService;
import com.zjh.yummy.dao.OrderGoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单表 Service 实现类
 *
 * @author zjh
 * @since 2019-03-28
 */
@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {

	@Autowired
    private OrderGoodsDao orderGoodsDao;

    /*
	 * 添加订单表
	 */
	@Override
	public int insert(OrderGoods orderGoods){
       return orderGoodsDao.insert(orderGoods);
    }
	/*
	 * 删除订单表
	 */
	@Override
	public int delete(int pkid){
       return orderGoodsDao.delete(pkid);
    }
	/*
	 * 修改订单表
	 */
	@Override
	public int update(OrderGoods orderGoods){
       return orderGoodsDao.update(orderGoods);
    }
	/*
	 * 查询所有订单表
	 */
	public List<OrderGoods> findList(SimpleQuery query){
		if(query == null){
			query = new SimpleQuery();
		}
		query.setOffset(0);
		query.setLimit(1000);
		List list = orderGoodsDao.list(query);
        return list;
    }
	/*
	 * 查询一个订单表
	 */
	public OrderGoods getById(Integer pkId){
       return orderGoodsDao.getById(pkId);
    }

	@Override
	public List<OrderGoods> restaurantCount(SimpleQuery query) {
		return orderGoodsDao.restaurantCount(query);
	}

	@Override
	public List<OrderGoods> userCount(SimpleQuery query) {
		return orderGoodsDao.userCount(query);
	}

	@Override
	public OrderGoods adminCount(SimpleQuery query) {
		BigDecimal bigDecimal = orderGoodsDao.adminCount(query);
		OrderGoods orderGoods = new OrderGoods();
		orderGoods.setAdminIn(bigDecimal);
		return orderGoods;
	}

	/*
	 * 分页查询订单表
	 */
	public BTableData page(SimpleQuery query){
		List list = orderGoodsDao.list(query);
		int count = orderGoodsDao.count(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }

	/*
	 * 分页查询订单表
	 */
	public BTableData pageByJoin(SimpleQuery query){
		List<OrderGoods> list = orderGoodsDao.listByJoin(query);
		int count = orderGoodsDao.countByJoin(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }
}
