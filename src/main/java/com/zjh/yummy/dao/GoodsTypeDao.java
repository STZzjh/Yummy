package com.zjh.yummy.dao;

import com.zjh.yummy.entity.GoodsType;
import com.zjh.yummy.common.db.SimpleQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 菜品类型 Mapper 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
@Repository
public interface GoodsTypeDao {
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
	 * 查询列表菜品类型
	 */
	List<GoodsType> list(SimpleQuery query);
	/*
	 * 统计菜品类型
	 */
	int count(SimpleQuery query);
	/*
	 * 查询列表
	 */
	List<GoodsType> listByJoin(SimpleQuery query);
    /*
    * 统计
    */
    int countByJoin(SimpleQuery query);
	/*
	 * 查询一个菜品类型
	 */
	GoodsType getById(Integer pkId);

}
