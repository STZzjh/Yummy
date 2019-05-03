package com.zjh.yummy.service;

import java.util.List;
import com.zjh.yummy.entity.Goods;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;

/**
 *
 * 菜单 Service 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
public interface GoodsService {
    /*
	 * 添加菜单
	 */
	int insert(Goods goods);
	/*
	 * 删除菜单
	 */
	int delete(int pkid);
	/*
	 * 修改菜单
	 */
	int update(Goods goods);

	/*
	 * 最多1000条菜单
	 */
	List<Goods> findList(SimpleQuery query);
	/*
	 * 分页菜单
	 */
	BTableData page(SimpleQuery query);

	BTableData pageByJoin(SimpleQuery query);
	/*
	 * 查询一个菜单
	 */
	Goods getById(Integer pkId);

}
