package com.zjh.yummy.controller.restaurant;

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
@RequestMapping("restaurant/order_goods_cw")
public class RestaurantOrderGoodsCwController {

    @Autowired
    private OrderGoodsService orderGoodsService;
    private String prefix = "restaurant/order_goods_cw/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "order_goods_cw";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query
            ,String timeStart,String timeEnd
            ,String moneyStart,String moneyEnd
            ,String userName){
        LoginUser user = SessionUtil.getUser();
        query.and("restaurant_id=",user.getId());
        query.and("restaurant_in is not null",null);
        if(!StringUtils.isEmpty(timeStart)){
            query.and("create_time>=",timeStart+" 00:00:00");
        }
        if(!StringUtils.isEmpty(timeEnd)){
            query.and("create_time<=",timeStart+" 23:59:59");
        }
        if(!StringUtils.isEmpty(moneyStart)){
            query.and("restaurant_in >=",moneyStart);
        }
        if(!StringUtils.isEmpty(moneyEnd)){
            query.and("restaurant_in <=",moneyEnd);
        }
        if(!StringUtils.isEmpty(userName)){
            query.and("user_name like","%"+userName+"%");
        }
        BTableData data = orderGoodsService.page(query);
        return data;
    }

}
