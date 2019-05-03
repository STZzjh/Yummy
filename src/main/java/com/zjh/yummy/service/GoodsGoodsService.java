package com.zjh.yummy.service;

import java.util.List;
import com.zjh.yummy.entity.GoodsGoods;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;

/**
 *
 * 套餐详情 Service 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
public interface GoodsGoodsService {
    /*
	 * 添加套餐详情
	 */
	int insert(GoodsGoods goodsGoods);
	/*
	 * 删除套餐详情
	 */
	int delete(int pkid);
	/*
	 * 修改套餐详情
	 */
	int update(GoodsGoods goodsGoods);

	/*
	 * 最多1000条套餐详情
	 */
	List<GoodsGoods> findList(SimpleQuery query);
	/*
	 * 分页套餐详情
	 */
	BTableData page(SimpleQuery query);

	BTableData pageByJoin(SimpleQuery query);
	/*
	 * 查询一个套餐详情
	 */
	GoodsGoods getById(Integer pkId);

}
