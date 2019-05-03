package com.zjh.yummy.dao;

import com.zjh.yummy.entity.Dict;
import com.zjh.yummy.common.db.SimpleQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 系统设置 Mapper 接口
 *
 * @author zjh
 * @since 2019-03-28
 */
@Repository
public interface DictDao {
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
	 * 查询列表系统设置
	 */
	List<Dict> list(SimpleQuery query);
	/*
	 * 统计系统设置
	 */
	int count(SimpleQuery query);
	/*
	 * 查询列表
	 */
	List<Dict> listByJoin(SimpleQuery query);
    /*
    * 统计
    */
    int countByJoin(SimpleQuery query);
	/*
	 * 查询一个系统设置
	 */
	Dict getById(Integer pkId);

}
