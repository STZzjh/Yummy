package com.zjh.yummy.service.impl;

import java.util.List;
import com.zjh.yummy.entity.UserAddress;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.service.UserAddressService;
import com.zjh.yummy.dao.UserAddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户地址 Service 实现类
 *
 * @author zjh
 * @since 2019-03-28
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {

	@Autowired
    private UserAddressDao userAddressDao;

    /*
	 * 添加用户地址
	 */
	@Override
	public int insert(UserAddress userAddress){
       return userAddressDao.insert(userAddress);
    }
	/*
	 * 删除用户地址
	 */
	@Override
	public int delete(int pkid){
       return userAddressDao.delete(pkid);
    }
	/*
	 * 修改用户地址
	 */
	@Override
	public int update(UserAddress userAddress){
       return userAddressDao.update(userAddress);
    }
	/*
	 * 查询所有用户地址
	 */
	public List<UserAddress> findList(SimpleQuery query){
		if(query == null){
			query = new SimpleQuery();
		}
		query.setOffset(0);
		query.setLimit(1000);
		List list = userAddressDao.list(query);
        return list;
    }
	/*
	 * 查询一个用户地址
	 */
	public UserAddress getById(Integer pkId){
       return userAddressDao.getById(pkId);
    }
	/*
	 * 分页查询用户地址
	 */
	public BTableData page(SimpleQuery query){
		List list = userAddressDao.list(query);
		int count = userAddressDao.count(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }

	/*
	 * 分页查询用户地址
	 */
	public BTableData pageByJoin(SimpleQuery query){
		List<UserAddress> list = userAddressDao.listByJoin(query);
		int count = userAddressDao.countByJoin(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }
}
