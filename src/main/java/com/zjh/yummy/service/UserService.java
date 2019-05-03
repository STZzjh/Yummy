package com.zjh.yummy.service;

import java.util.List;

import com.zjh.yummy.entity.User;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;

/**
 *
 * 用户 Service 接口
 *
 * @author saoft
 * @since 2019-03-14
 */
public interface UserService {
    /*
	 * 添加用户
	 */
	int insert(User user);
	/*
	 * 删除用户
	 */
	int delete(int pkid);
	/*
	 * 修改用户
	 */
	int update(User user);

	/*
	 * 最多1000条用户
	 */
	List findList();
	List findList(SimpleQuery query);
	/*
	 * 分页用户
	 */
	BTableData page(SimpleQuery query);
	/*
	 * 查询一个用户
	 */
	User getById(Integer pkId);

    User login(String username);
}
