package com.zjh.yummy.service.impl;

import java.util.HashMap;
import java.util.List;
import com.zjh.yummy.entity.Dict;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.service.DictService;
import com.zjh.yummy.dao.DictDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统设置 Service 实现类
 *
 * @author zjh
 * @since 2019-03-28
 */
@Service
public class DictServiceImpl implements DictService {

	@Autowired
    private DictDao dictDao;

    /*
	 * 添加系统设置
	 */
	@Override
	public int insert(Dict dict){
       return dictDao.insert(dict);
    }
	/*
	 * 删除系统设置
	 */
	@Override
	public int delete(int pkid){
       return dictDao.delete(pkid);
    }
	/*
	 * 修改系统设置
	 */
	@Override
	public int update(Dict dict){
       return dictDao.update(dict);
    }
	/*
	 * 查询所有系统设置
	 */
	public List<Dict> findList(SimpleQuery query){
		if(query == null){
			query = new SimpleQuery();
		}
		query.setOffset(0);
		query.setLimit(1000);
		List list = dictDao.list(query);
        return list;
    }
	/*
	 * 查询一个系统设置
	 */
	public Dict getById(Integer pkId){
       return dictDao.getById(pkId);
    }

	@Override
	public HashMap<String, String> getSetting() {
		List<Dict> list = findList(null);
		HashMap<String, String> map = new HashMap<>();
		for (Dict dict : list) {
			map.put(dict.getCode(), dict.getValue());
		}
		return map;
	}

	/*
	 * 分页查询系统设置
	 */
	public BTableData page(SimpleQuery query){
		List list = dictDao.list(query);
		int count = dictDao.count(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }

	/*
	 * 分页查询系统设置
	 */
	public BTableData pageByJoin(SimpleQuery query){
		List<Dict> list = dictDao.listByJoin(query);
		int count = dictDao.countByJoin(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }
}
