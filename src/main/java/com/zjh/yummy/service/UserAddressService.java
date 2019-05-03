package com.zjh.yummy.service;

import java.util.List;
import com.zjh.yummy.entity.UserAddress;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;

/**
 *
 * 用户地址 Service 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
public interface UserAddressService {
    /*
	 * 添加用户地址
	 */
	int insert(UserAddress userAddress);
	/*
	 * 删除用户地址
	 */
	int delete(int pkid);
	/*
	 * 修改用户地址
	 */
	int update(UserAddress userAddress);

	/*
	 * 最多1000条用户地址
	 */
	List<UserAddress> findList(SimpleQuery query);
	/*
	 * 分页用户地址
	 */
	BTableData page(SimpleQuery query);

	BTableData pageByJoin(SimpleQuery query);
	/*
	 * 查询一个用户地址
	 */
	UserAddress getById(Integer pkId);

}
