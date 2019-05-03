package com.zjh.yummy.service.impl;

import java.util.List;
import com.zjh.yummy.entity.GoodsGoods;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.service.GoodsGoodsService;
import com.zjh.yummy.dao.GoodsGoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 套餐详情 Service 实现类
 *
 * @author zjh
 * @since 2019-03-28
 */
@Service
public class GoodsGoodsServiceImpl implements GoodsGoodsService {

	@Autowired
    private GoodsGoodsDao goodsGoodsDao;

    /*
	 * 添加套餐详情
	 */
	@Override
	public int insert(GoodsGoods goodsGoods){
       return goodsGoodsDao.insert(goodsGoods);
    }
	/*
	 * 删除套餐详情
	 */
	@Override
	public int delete(int pkid){
       return goodsGoodsDao.delete(pkid);
    }
	/*
	 * 修改套餐详情
	 */
	@Override
	public int update(GoodsGoods goodsGoods){
       return goodsGoodsDao.update(goodsGoods);
    }
	/*
	 * 查询所有套餐详情
	 */
	public List<GoodsGoods> findList(SimpleQuery query){
		if(query == null){
			query = new SimpleQuery();
		}
		query.setOffset(0);
		query.setLimit(1000);
		List list = goodsGoodsDao.list(query);
        return list;
    }
	/*
	 * 查询一个套餐详情
	 */
	public GoodsGoods getById(Integer pkId){
       return goodsGoodsDao.getById(pkId);
    }
	/*
	 * 分页查询套餐详情
	 */
	public BTableData page(SimpleQuery query){
		List list = goodsGoodsDao.list(query);
		int count = goodsGoodsDao.count(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }

	/*
	 * 分页查询套餐详情
	 */
	public BTableData pageByJoin(SimpleQuery query){
		List<GoodsGoods> list = goodsGoodsDao.listByJoin(query);
		int count = goodsGoodsDao.countByJoin(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }
}
