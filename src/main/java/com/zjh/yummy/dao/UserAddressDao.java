package com.zjh.yummy.dao;

import com.zjh.yummy.entity.UserAddress;
import com.zjh.yummy.common.db.SimpleQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 用户地址 Mapper 接口
 *
 * @author zjh
 * @since 2019-03-29
 */
@Repository
public interface UserAddressDao {
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
	 * 查询列表用户地址
	 */
	List<UserAddress> list(SimpleQuery query);
	/*
	 * 统计用户地址
	 */
	int count(SimpleQuery query);
	/*
	 * 查询列表
	 */
	List<UserAddress> listByJoin(SimpleQuery query);
    /*
    * 统计
    */
    int countByJoin(SimpleQuery query);
	/*
	 * 查询一个用户地址
	 */
	UserAddress getById(Integer pkId);

}
