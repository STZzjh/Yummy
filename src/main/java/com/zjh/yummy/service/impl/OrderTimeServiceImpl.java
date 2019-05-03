package com.zjh.yummy.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.SessionUtil;
import com.zjh.yummy.dao.OrderGoodsDao;
import com.zjh.yummy.entity.OrderGoods;
import com.zjh.yummy.entity.OrderTime;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.entity.User;
import com.zjh.yummy.service.DictService;
import com.zjh.yummy.service.OrderTimeService;
import com.zjh.yummy.dao.OrderTimeDao;
import com.zjh.yummy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单时间 Service 实现类
 *
 * @author zjh
 * @since 2019-03-28
 */
@Service
public class OrderTimeServiceImpl implements OrderTimeService {

	@Autowired
    private OrderTimeDao orderTimeDao;

	@Autowired
	private OrderGoodsDao orderGoodsDao;

	@Autowired
	private UserService userService;

	@Autowired
	private DictService dictService;

    /*
	 * 添加订单时间
	 */
	@Override
	public int insert(OrderTime orderTime){
		HashMap<String, String> setting = dictService.getSetting();
		//更新订单状态
		SimpleQuery query = new SimpleQuery();
		query.and("order_no=", orderTime.getOrderNo());
		List<OrderGoods> list = orderGoodsDao.list(query);
		if (list != null && list.size() == 1) {
			OrderGoods orderGoods = list.get(0);
			OrderGoods newOG = new OrderGoods();
			//根据每个变化的状态计算各自的money
			String status = orderTime.getStatus();
			//付款
			if("2".equals(status)){
				//用户金钱减少
				BigDecimal price = orderGoods.getPrice();
				LoginUser user = SessionUtil.getUser();
				User user1 = userService.getById(user.getId());
				//余额不足
				if (user1.getMoney().compareTo(price) < 0) {
					throw new RuntimeException();
				}
				BigDecimal subtract = user1.getMoney().subtract(price);
				User updateUser = new User();
				updateUser.setId(user.getId());
				updateUser.setMoney(subtract);
				userService.update(updateUser);
			}
			if("4".equals(status)){//确认收货

				String yummyRate = setting.get("YummyRate");
				BigDecimal bigDecimal = new BigDecimal(yummyRate);
				BigDecimal price = orderGoods.getPrice();
				BigDecimal multiply = price.multiply(bigDecimal);
				newOG.setAdminIn(multiply);
				newOG.setUserIn(BigDecimal.ZERO);
				newOG.setRestaurantIn(price.subtract(multiply));
			}
			if("5".equals(status)){//退订
				//支付时间
				SimpleQuery query1 = new SimpleQuery();
				query1.and("order_no=",orderGoods.getOrderNo());
				query1.and("status=","2");
				List<OrderTime> list1 = orderTimeDao.list(query1);
				OrderTime orderTime1 = list1.get(0);
				//时差
				int diff = (int) ((System.currentTimeMillis() - orderTime1.getStatusTime().getTime())/1000/60);
				//属于哪个等级
				Integer back50 = Integer.parseInt(setting.get("Back50"));
				Integer back80 = Integer.parseInt(setting.get("Back80"));
				if(diff > back50 ){//草果反50%的时间
					BigDecimal price = orderGoods.getPrice();
					String yummyRate =  setting.get("YummyRate");
					BigDecimal bigDecimal = new BigDecimal(yummyRate);
					BigDecimal multiply = price.multiply(bigDecimal);
					newOG.setUserIn(BigDecimal.ZERO);
					newOG.setAdminIn(multiply);
					newOG.setRestaurantIn(price.subtract(multiply));
				}else if(diff > back80){//反80%的时间

					BigDecimal price = orderGoods.getPrice();
					BigDecimal multiply = price.multiply(new BigDecimal("0.8"));
					newOG.setUserIn(multiply);

					BigDecimal shengyu = price.subtract(multiply);
					String yummyRate = setting.get("YummyRate");
					BigDecimal bigDecimal = new BigDecimal(yummyRate);

					BigDecimal multiply1 = shengyu.multiply(bigDecimal);
					newOG.setAdminIn(multiply);

					newOG.setRestaurantIn(shengyu.subtract(multiply1));
				}else{//反50%

					BigDecimal price = orderGoods.getPrice();
					BigDecimal multiply = price.multiply(new BigDecimal("0.5"));
					newOG.setUserIn(multiply);

					BigDecimal shengyu = price.subtract(multiply);
					String yummyRate = setting.get("YummyRate");
					BigDecimal bigDecimal = new BigDecimal(yummyRate);

					BigDecimal multiply1 = shengyu.multiply(bigDecimal);
					newOG.setAdminIn(multiply);

					newOG.setRestaurantIn(shengyu.subtract(multiply1));
				}
			}

			newOG.setId(orderGoods.getId());
			newOG.setStatus(orderTime.getStatus());
			orderGoodsDao.update(newOG);
		}


		return orderTimeDao.insert(orderTime);
    }
	/*
	 * 删除订单时间
	 */
	@Override
	public int delete(int pkid){
       return orderTimeDao.delete(pkid);
    }
	/*
	 * 修改订单时间
	 */
	@Override
	public int update(OrderTime orderTime){
       return orderTimeDao.update(orderTime);
    }
	/*
	 * 查询所有订单时间
	 */
	public List<OrderTime> findList(SimpleQuery query){
		if(query == null){
			query = new SimpleQuery();
		}
		query.setOffset(0);
		query.setLimit(1000);
		List list = orderTimeDao.list(query);
        return list;
    }
	/*
	 * 查询一个订单时间
	 */
	public OrderTime getById(Integer pkId){
       return orderTimeDao.getById(pkId);
    }
	/*
	 * 分页查询订单时间
	 */
	public BTableData page(SimpleQuery query){
		List list = orderTimeDao.list(query);
		int count = orderTimeDao.count(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }

	/*
	 * 分页查询订单时间
	 */
	public BTableData pageByJoin(SimpleQuery query){
		List<OrderTime> list = orderTimeDao.listByJoin(query);
		int count = orderTimeDao.countByJoin(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }
}
