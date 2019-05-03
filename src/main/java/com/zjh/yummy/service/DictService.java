package com.zjh.yummy.service;

import java.util.HashMap;
import java.util.List;
import com.zjh.yummy.entity.Dict;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;

/**
 *
 * 系统设置 Service 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
public interface DictService {
    /*
	 * 添加系统设置
	 */
	int insert(Dict dict);
	/*
	 * 删除系统设置
	 */
	int delete(int pkid);
	/*
	 * 修改系统设置
	 */
	int update(Dict dict);

	/*
	 * 最多1000条系统设置
	 */
	List<Dict> findList(SimpleQuery query);
	/*
	 * 分页系统设置
	 */
	BTableData page(SimpleQuery query);

	BTableData pageByJoin(SimpleQuery query);
	/*
	 * 查询一个系统设置
	 */
	Dict getById(Integer pkId);

    HashMap<String,String> getSetting();
}
