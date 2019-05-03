package com.zjh.yummy.dao;

import com.zjh.yummy.entity.Admin;
import com.zjh.yummy.common.db.SimpleQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author saoft
 * @since 2019-03-14
 */
@Repository
public interface AdminDao {
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
	 * 查询列表
	 */
	List<Admin> list(SimpleQuery query);
	/*
	 * 统计
	 */
	int count(SimpleQuery query);
	/*
	 * 查询一个
	 */
	Admin getById(Integer pkId);

}
