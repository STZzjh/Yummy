package com.zjh.yummy.controller.user;

import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.SessionUtil;
import com.zjh.yummy.entity.OrderGoods;
import com.zjh.yummy.service.OrderGoodsService;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.common.web.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("user/order_goods_xf")
public class UserOrderGoodsXfController {

    @Autowired
    private OrderGoodsService orderGoodsService;
    private String prefix = "user/order_goods_xf/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "order_goods_xf";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query
            ,String timeStart,String timeEnd
            ,String moneyStart,String moneyEnd
            ,String restaurantName){
        LoginUser user = SessionUtil.getUser();
        query.and("user_id=",user.getId());
        if(!StringUtils.isEmpty(timeStart)){
            query.and("create_time>=",timeStart+" 00:00:00");
        }
        if(!StringUtils.isEmpty(timeEnd)){
            query.and("create_time<=",timeStart+" 23:59:59");
        }
        if(!StringUtils.isEmpty(moneyStart)){
            query.and("price >=",moneyStart);
        }
        if(!StringUtils.isEmpty(moneyEnd)){
            query.and("price <=",moneyEnd);
        }
        if(!StringUtils.isEmpty(restaurantName)){
            query.and("restaurant_name like","%"+restaurantName+"%");
        }
        BTableData data = orderGoodsService.page(query);
        return data;
    }

}
