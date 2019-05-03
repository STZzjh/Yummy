package com.zjh.yummy.service.impl;

import java.util.List;
import com.zjh.yummy.entity.RestType;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.service.RestTypeService;
import com.zjh.yummy.dao.RestTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 餐厅类型 Service 实现类
 *
 * @author zjh
 * @since 2019-03-28
 */
@Service
public class RestTypeServiceImpl implements RestTypeService {

	@Autowired
    private RestTypeDao restTypeDao;

    /*
	 * 添加餐厅类型
	 */
	@Override
	public int insert(RestType restType){
       return restTypeDao.insert(restType);
    }
	/*
	 * 删除餐厅类型
	 */
	@Override
	public int delete(int pkid){
       return restTypeDao.delete(pkid);
    }
	/*
	 * 修改餐厅类型
	 */
	@Override
	public int update(RestType restType){
       return restTypeDao.update(restType);
    }
	/*
	 * 查询所有餐厅类型
	 */
	public List<RestType> findList(SimpleQuery query){
		if(query == null){
			query = new SimpleQuery();
		}
		query.setOffset(0);
		query.setLimit(1000);
		List list = restTypeDao.list(query);
        return list;
    }
	/*
	 * 查询一个餐厅类型
	 */
	public RestType getById(Integer pkId){
       return restTypeDao.getById(pkId);
    }
	/*
	 * 分页查询餐厅类型
	 */
	public BTableData page(SimpleQuery query){
		List list = restTypeDao.list(query);
		int count = restTypeDao.count(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }

	/*
	 * 分页查询餐厅类型
	 */
	public BTableData pageByJoin(SimpleQuery query){
		List<RestType> list = restTypeDao.listByJoin(query);
		int count = restTypeDao.countByJoin(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }
}
