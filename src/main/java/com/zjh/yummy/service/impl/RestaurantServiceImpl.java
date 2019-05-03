package com.zjh.yummy.service.impl;

import java.util.List;
import com.zjh.yummy.entity.Restaurant;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.service.RestaurantService;
import com.zjh.yummy.dao.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 餐馆 Service 实现类
 *
 * @author zjh
 * @since 2019-03-28
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
    private RestaurantDao restaurantDao;

    /*
	 * 添加餐馆
	 */
	@Override
	public int insert(Restaurant restaurant){
       return restaurantDao.insert(restaurant);
    }
	/*
	 * 删除餐馆
	 */
	@Override
	public int delete(int pkid){
       return restaurantDao.delete(pkid);
    }
	/*
	 * 修改餐馆
	 */
	@Override
	public int update(Restaurant restaurant){
       return restaurantDao.update(restaurant);
    }
	/*
	 * 查询所有餐馆
	 */
	public List<Restaurant> findList(SimpleQuery query){
		if(query == null){
			query = new SimpleQuery();
		}
		query.setOffset(0);
		if(query.getLimit()==null || query.getLimit()<1){
			query.setLimit(1000);
		}

		List list = restaurantDao.list(query);
        return list;
    }
	/*
	 * 查询一个餐馆
	 */
	public Restaurant getById(Integer pkId){
       return restaurantDao.getById(pkId);
    }

	@Override
	public Restaurant login(String username) {
		SimpleQuery query = new SimpleQuery();
		SimpleQuery.Condition condition = new SimpleQuery.Condition("login_no=", username);
		query.getConditionList().add(condition);
		List list = restaurantDao.list(query);
		if (list != null && list.size() == 1) {
			return (Restaurant) list.get(0);
		}
		return null;
	}

	/*
	 * 分页查询餐馆
	 */
	public BTableData page(SimpleQuery query){
		List list = restaurantDao.list(query);
		int count = restaurantDao.count(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }

	/*
	 * 分页查询餐馆
	 */
	public BTableData pageByJoin(SimpleQuery query){
		List<Restaurant> list = restaurantDao.listByJoin(query);
		int count = restaurantDao.countByJoin(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }
}
