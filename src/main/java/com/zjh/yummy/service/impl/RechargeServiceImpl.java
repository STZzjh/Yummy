package com.zjh.yummy.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.zjh.yummy.dao.UserDao;
import com.zjh.yummy.entity.Recharge;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.entity.User;
import com.zjh.yummy.service.RechargeService;
import com.zjh.yummy.dao.RechargeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 充值记录 Service 实现类
 *
 * @author zjh
 * @since 2019-03-28
 */
@Service
public class RechargeServiceImpl implements RechargeService {

	@Autowired
    private RechargeDao rechargeDao;

	@Autowired
	private UserDao userDao;

    /*
	 * 添加充值记录
	 */
	@Override
	public int insert(Recharge recharge){
		User user = userDao.getById(recharge.getUserId());
		User updateUser = new User();
		updateUser.setId(user.getId());
		BigDecimal userMoney = user.getMoney();
		if (userMoney == null) {
			userMoney = BigDecimal.ZERO;
		}
		userMoney = userMoney.add(recharge.getMoney());
		updateUser.setMoney(userMoney);
		userDao.update(updateUser);
		return rechargeDao.insert(recharge);
    }
	/*
	 * 删除充值记录
	 */
	@Override
	public int delete(int pkid){
       return rechargeDao.delete(pkid);
    }
	/*
	 * 修改充值记录
	 */
	@Override
	public int update(Recharge recharge){
       return rechargeDao.update(recharge);
    }
	/*
	 * 查询所有充值记录
	 */
	public List<Recharge> findList(SimpleQuery query){
		if(query == null){
			query = new SimpleQuery();
		}
		query.setOffset(0);
		query.setLimit(1000);
		List list = rechargeDao.list(query);
        return list;
    }
	/*
	 * 查询一个充值记录
	 */
	public Recharge getById(Integer pkId){
       return rechargeDao.getById(pkId);
    }
	/*
	 * 分页查询充值记录
	 */
	public BTableData page(SimpleQuery query){
		List list = rechargeDao.list(query);
		int count = rechargeDao.count(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }

	/*
	 * 分页查询充值记录
	 */
	public BTableData pageByJoin(SimpleQuery query){
		List<Recharge> list = rechargeDao.listByJoin(query);
		int count = rechargeDao.countByJoin(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }
}
