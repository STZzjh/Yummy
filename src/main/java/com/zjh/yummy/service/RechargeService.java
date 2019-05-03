package com.zjh.yummy.service;

import java.util.List;
import com.zjh.yummy.entity.Recharge;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;

/**
 *
 * 充值记录 Service 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
public interface RechargeService {
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
	 * 最多1000条充值记录
	 */
	List<Recharge> findList(SimpleQuery query);
	/*
	 * 分页充值记录
	 */
	BTableData page(SimpleQuery query);

	BTableData pageByJoin(SimpleQuery query);
	/*
	 * 查询一个充值记录
	 */
	Recharge getById(Integer pkId);

}
