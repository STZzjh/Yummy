package com.zjh.yummy.service.impl;

import java.util.List;

import com.zjh.yummy.dao.AdminDao;
import com.zjh.yummy.service.AdminService;
import com.zjh.yummy.entity.Admin;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Service 实现类
 *
 * @author saoft
 * @since 2019-03-14
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminDao adminDao;

    /*
	 * 添加
	 */
	@Override
	public int insert(Admin admin){
       return adminDao.insert(admin);
    }
	/*
	 * 删除
	 */
	@Override
	public int delete(int pkid){
       return adminDao.delete(pkid);
    }
	/*
	 * 修改
	 */
	@Override
	public int update(Admin admin){
       return adminDao.update(admin);
    }
	/*
	 * 查询所有
	 */
	public List findList(){
		SimpleQuery query = new SimpleQuery();
		query.setOffset(0);
		query.setLimit(1000);
		List list = adminDao.list(query);
        return list;
    }
	/*
	 * 查询一个
	 */
	public Admin getById(Integer pkId){
       return adminDao.getById(pkId);
    }

	@Override
	public Admin login(String username) {
		SimpleQuery query = new SimpleQuery();
		SimpleQuery.Condition condition = new SimpleQuery.Condition("username=", username);
		query.getConditionList().add(condition);
		List list = adminDao.list(query);
		if (list != null && list.size() == 1) {
			return (Admin) list.get(0);
		}
		return null;
	}

	/*
	 * 分页查询
	 */
	public BTableData page(SimpleQuery query){
		List list = adminDao.list(query);
		int count = adminDao.count(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }
}
