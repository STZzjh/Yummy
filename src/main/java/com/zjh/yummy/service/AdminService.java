package com.zjh.yummy.service;

import java.util.List;
import com.zjh.yummy.entity.Admin;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;

/**
 *
 *  Service 接口
 *
 * @author saoft
 * @since 2019-03-14
 */
public interface AdminService {
    /*
	 * 添加
	 */
	int insert(Admin admin);
	/*
	 * 删除
	 */
	int delete(int pkid);
	/*
	 * 修改
	 */
	int update(Admin admin);

	/*
	 * 最多1000条
	 */
	List findList();
	/*
	 * 分页
	 */
	BTableData page(SimpleQuery query);
	/*
	 * 查询一个
	 */
	Admin getById(Integer pkId);

    Admin login(String username);
}
