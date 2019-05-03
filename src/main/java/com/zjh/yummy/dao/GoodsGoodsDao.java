package com.zjh.yummy.dao;

import com.zjh.yummy.entity.GoodsGoods;
import com.zjh.yummy.common.db.SimpleQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 套餐详情 Mapper 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
@Repository
public interface GoodsGoodsDao {
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
	 * 查询列表套餐详情
	 */
	List<GoodsGoods> list(SimpleQuery query);
	/*
	 * 统计套餐详情
	 */
	int count(SimpleQuery query);
	/*
	 * 查询列表
	 */
	List<GoodsGoods> listByJoin(SimpleQuery query);
    /*
    * 统计
    */
    int countByJoin(SimpleQuery query);
	/*
	 * 查询一个套餐详情
	 */
	GoodsGoods getById(Integer pkId);

}
