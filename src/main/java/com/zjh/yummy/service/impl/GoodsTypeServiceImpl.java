package com.zjh.yummy.service.impl;

import java.util.List;
import com.zjh.yummy.entity.GoodsType;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.service.GoodsTypeService;
import com.zjh.yummy.dao.GoodsTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 菜品类型 Service 实现类
 *
 * @author zjh
 * @since 2019-03-28
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

	@Autowired
    private GoodsTypeDao goodsTypeDao;

    /*
	 * 添加菜品类型
	 */
	@Override
	public int insert(GoodsType goodsType){
       return goodsTypeDao.insert(goodsType);
    }
	/*
	 * 删除菜品类型
	 */
	@Override
	public int delete(int pkid){
       return goodsTypeDao.delete(pkid);
    }
	/*
	 * 修改菜品类型
	 */
	@Override
	public int update(GoodsType goodsType){
       return goodsTypeDao.update(goodsType);
    }
	/*
	 * 查询所有菜品类型
	 */
	public List<GoodsType> findList(SimpleQuery query){
		if(query == null){
			query = new SimpleQuery();
		}
		query.setOffset(0);
		query.setLimit(1000);
		List list = goodsTypeDao.list(query);
        return list;
    }
	/*
	 * 查询一个菜品类型
	 */
	public GoodsType getById(Integer pkId){
       return goodsTypeDao.getById(pkId);
    }
	/*
	 * 分页查询菜品类型
	 */
	public BTableData page(SimpleQuery query){
		List list = goodsTypeDao.list(query);
		int count = goodsTypeDao.count(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }

	/*
	 * 分页查询菜品类型
	 */
	public BTableData pageByJoin(SimpleQuery query){
		List<GoodsType> list = goodsTypeDao.listByJoin(query);
		int count = goodsTypeDao.countByJoin(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }
}
