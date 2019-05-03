package com.zjh.yummy.dao;

import com.zjh.yummy.entity.Goods;
import com.zjh.yummy.common.db.SimpleQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 菜单 Mapper 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
@Repository
public interface GoodsDao {
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
	 * 查询列表菜单
	 */
	List<Goods> list(SimpleQuery query);
	/*
	 * 统计菜单
	 */
	int count(SimpleQuery query);
	/*
	 * 查询列表
	 */
	List<Goods> listByJoin(SimpleQuery query);
    /*
    * 统计
    */
    int countByJoin(SimpleQuery query);
	/*
	 * 查询一个菜单
	 */
	Goods getById(Integer pkId);

}
