package com.zjh.yummy.service;

import java.util.List;
import com.zjh.yummy.entity.GoodsType;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;

/**
 *
 * 菜品类型 Service 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
public interface GoodsTypeService {
    /*
	 * 添加菜品类型
	 */
	int insert(GoodsType goodsType);
	/*
	 * 删除菜品类型
	 */
	int delete(int pkid);
	/*
	 * 修改菜品类型
	 */
	int update(GoodsType goodsType);

	/*
	 * 最多1000条菜品类型
	 */
	List<GoodsType> findList(SimpleQuery query);
	/*
	 * 分页菜品类型
	 */
	BTableData page(SimpleQuery query);

	BTableData pageByJoin(SimpleQuery query);
	/*
	 * 查询一个菜品类型
	 */
	GoodsType getById(Integer pkId);

}
