package com.zjh.yummy.service.impl;

import java.util.List;

import com.zjh.yummy.common.RandomUtil;
import com.zjh.yummy.common.email.SendMail;
import com.zjh.yummy.dao.UserDao;
import com.zjh.yummy.entity.User;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户 Service 实现类
 *
 * @author saoft
 * @since 2019-03-14
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;

    /*
	 * 添加用户
	 */
	@Override
	public int insert(User user){
		String randomString = RandomUtil.getRandomString(6);
		user.setVcode(randomString);
		user.setStatus("1");
		userDao.insert(user);
		String content = "<div>\n" +
				"    <table style=\"width:600px\">\n" +
				"        <tbody>\n" +
				"        <tr>\n" +
				"            <td style=\"height:30px;text-align:left\">尊敬的用户：</td>\n" +
				"        </tr>\n" +
				"        <tr>\n" +
				"            <td style=\"height:30px;text-align:left\">您好！</td>\n" +
				"        </tr>\n" +
				"        <tr>\n" +
				"            <td style=\"height:30px;text-align:left; padding-left:20px\"> 您已在本网站注册成功, 会员网站地址为:<a\n" +
				"                    href=\"http://localhost:8080/\" target=\"_blank\" rel=\"noopener\">http://127.0.0.1:8080/</a></td>\n" +
				"        </tr>\n" +
				"        <tr>\n" +
				"            <td style=\"height:30px;text-align:left; padding-left:20px\">感谢您使用Yummy的服务, 如果您需要了解更多Yummy相关的信息, 请登录我们的网站\n" +
				"            </td>\n" +
				"        </tr>\n" +
				"        <tr>\n" +
				"            <td style=\"height:30px;text-align:left; padding-left:20px\">希望您继续支持我们</td>\n" +
				"        </tr>\n" +
				"        <tr>\n" +
				"            <td style=\"height:50px;text-align:left; padding-left:20px\">Yummy</td>\n" +
				"        </tr>\n" +
				"        <tr>\n" +
				"            <td style=\"height:20px;text-align:left; padding-left:20px\">激活您帐户的链接为:<a\n" +
				"                    href=\"http://localhost:8080/user/activate?token="+user.getUsername()+"&code="+user.getVcode()+"\" target=\"_blank\"\n" +
				"                    style=\"color:blue\" title=\"点击激活您的账户！\" rel=\"noopener\">http://localhost:8080/user/activate?token="+user.getUsername()+"&code="+user.getVcode()+"</a>\n" +
				"            </td>\n" +
				"        </tr>\n" +
				"        </tbody>\n" +
				"    </table>\n" +
				"</div>";
		SendMail sendMail = new SendMail();
		sendMail.send(user.getEmail(),content);
		return 1;
    }
	/*
	 * 删除用户
	 */
	@Override
	public int delete(int pkid){
       return userDao.delete(pkid);
    }
	/*
	 * 修改用户
	 */
	@Override
	public int update(User user){
       return userDao.update(user);
    }
	/*
	 * 查询所有用户
	 */
	public List findList(){
		SimpleQuery query = new SimpleQuery();
		query.setOffset(0);
		query.setLimit(1000);
		List list = userDao.list(query);
        return list;
    }

	@Override
	public List findList(SimpleQuery query) {
		query.setOffset(0);
		query.setLimit(1000);
		List list = userDao.list(query);
		return list;
	}

	/*
	 * 查询一个用户
	 */
	public User getById(Integer pkId){
       return userDao.getById(pkId);
    }

	@Override
	public User login(String username) {
		SimpleQuery query = new SimpleQuery();
		SimpleQuery.Condition condition = new SimpleQuery.Condition("username=", username);
		query.getConditionList().add(condition);
		List list = userDao.list(query);
		if (list != null && list.size() == 1) {
			return (User) list.get(0);
		}
		return null;
	}

	/*
	 * 分页查询用户
	 */
	public BTableData page(SimpleQuery query){
		List list = userDao.list(query);
		int count = userDao.count(query);
		BTableData data = new BTableData();
		data.setRows(list);
		data.setTotal(count);
        return data;
    }
}
