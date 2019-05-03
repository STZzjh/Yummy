package com.zjh.yummy.dao;

import com.zjh.yummy.entity.Recharge;
import com.zjh.yummy.common.db.SimpleQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 充值记录 Mapper 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
@Repository
public interface RechargeDao {
    /*
	 * 添加充值记录
	 */
	int insert(Recharge recharge);
	/*
	 * 删除充值记录
	 */
	int delete(int pkid);
	/*
	 * 修改充值记录
	 */
	int update(Recharge recharge);
	/*
	 * 查询列表充值记录
	 */
	List<Recharge> list(SimpleQuery query);
	/*
	 * 统计充值记录
	 */
	int count(SimpleQuery query);
	/*
	 * 查询列表
	 */
	List<Recharge> listByJoin(SimpleQuery query);
    /*
    * 统计
    */
    int countByJoin(SimpleQuery query);
	/*
	 * 查询一个充值记录
	 */
	Recharge getById(Integer pkId);

}
