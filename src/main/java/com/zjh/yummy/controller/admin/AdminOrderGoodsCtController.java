package com.zjh.yummy.controller.admin;

import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.SessionUtil;
import com.zjh.yummy.entity.OrderGoods;
import com.zjh.yummy.entity.Restaurant;
import com.zjh.yummy.service.OrderGoodsService;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.common.web.Msg;
import com.zjh.yummy.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("admin/order_goods_ct")
public class AdminOrderGoodsCtController {

    @Autowired
    private OrderGoodsService orderGoodsService;

    @Autowired
    private RestaurantService restaurantService;
    private String prefix = "admin/order_goods_ct/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "order_goods_ct";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        List<OrderGoods> orderGoods = orderGoodsService.restaurantCount(query);
        for (OrderGoods orderGood : orderGoods) {
            Restaurant restaurant = restaurantService.getById(orderGood.getRestaurantId());
            if (restaurant != null) {
                orderGood.setRestaurantName(restaurant.getName());
            }
        }
        BTableData data = new BTableData();
        data.setRows(orderGoods);
        data.setTotal(orderGoods.size());
        return data;
    }

}
