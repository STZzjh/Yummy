package com.zjh.yummy.service.impl;

import java.util.List;
import com.zjh.yummy.entity.Goods;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.service.GoodsService;
import com.zjh.yummy.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 菜单 Service 实现类
 *
 * @author zjh
 * @since 2019-03-28
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
    private GoodsDao goodsDao;

    /*
	 * 添加菜单
	 */
	@Override
	public int insert(Goods goods){
       return goodsDao.insert(goods);
    }
	/*
	 * 删除菜单
	 */
	@Override
	public int delete(int pkid){
       return goodsDao.delete(pkid);
    }
	/*
	 * 修改菜单
	 */
	@Override
	public int update(Goods goods){
       return goodsDao.update(goods);
    }
	/*
	 * 查询所有菜单
	 */
	public List<Goods> findList(SimpleQuery query){
		if(query == null){
			query = new SimpleQuery();
		}
		query.setOffset(0);
		query.setLimit(1000);
		List list = goodsDao.list(query);
        return list;
    }
	/*
	 * 查询一个菜单
	 */
	public Goods getById(Integer pkId){
       return goodsDao.getById(pkId);
    }
	/*
	 * 分页查询菜单
	 */
	public BTableData page(SimpleQuery query){
		List list = goodsDao.list(query);
		int count = goodsDao.count(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }

	/*
	 * 分页查询菜单
	 */
	public BTableData pageByJoin(SimpleQuery query){
		List<Goods> list = goodsDao.listByJoin(query);
		int count = goodsDao.countByJoin(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }
}
