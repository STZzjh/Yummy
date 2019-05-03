package com.zjh.yummy.dao;

import com.zjh.yummy.entity.User;
import com.zjh.yummy.common.db.SimpleQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 用户 Mapper 接口
 *
 * @author zjh
 * @since 2019-03-29
 */
@Repository
public interface UserDao {
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
	 * 查询列表用户
	 */
	List<User> list(SimpleQuery query);
	/*
	 * 统计用户
	 */
	int count(SimpleQuery query);
	/*
	 * 查询列表
	 */
	List<User> listByJoin(SimpleQuery query);
    /*
    * 统计
    */
    int countByJoin(SimpleQuery query);
	/*
	 * 查询一个用户
	 */
	User getById(Integer pkId);

}
