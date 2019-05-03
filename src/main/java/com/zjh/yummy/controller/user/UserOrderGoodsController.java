package com.zjh.yummy.controller.user;

import com.zjh.yummy.common.OrderUtil;
import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.SessionUtil;
import com.zjh.yummy.entity.*;
import com.zjh.yummy.service.*;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.common.web.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("user/order_goods")
public class UserOrderGoodsController {

    @Autowired
    private OrderGoodsService orderGoodsService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private DictService dictService;
    @Autowired
    private OrderTimeService orderTimeService;


    private String prefix = "user/order_goods/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "order_goods";
    }

    @RequestMapping(value = "order_goods_add",method = RequestMethod.GET)
    public String pageAdd(Integer goodsId,Model model){
        Goods goods = goodsService.getById(goodsId);
        Restaurant restaurant = restaurantService.getById(goods.getRestaurantId());
        List<UserAddress> userAddressList = userAddressService.findList(null);
        HashMap<String,String> setting = dictService.getSetting();
        model.addAttribute("setting", setting);
        model.addAttribute("goods", goods);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("userAddressList", userAddressList);
        return prefix + "order_goods_add";
    }

    @RequestMapping(value = "order_goods_edit", method = RequestMethod.GET)
    public String pageEdit(Model model, Integer id) {
        OrderGoods orderGoods = orderGoodsService.getById(id);
        model.addAttribute("item", orderGoods);
        List<Restaurant> restaurantList = restaurantService.findList(null);
        List<Goods> goodsList = goodsService.findList(null);
        List<UserAddress> userAddressList = userAddressService.findList(null);
        model.addAttribute("restaurantList", restaurantList);
        model.addAttribute("goodsList", goodsList);
        model.addAttribute("userAddressList", userAddressList);
        return prefix + "order_goods_edit";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        query.and("user_id=", SessionUtil.getUser().getId());
        BTableData data = orderGoodsService.page(query);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(OrderGoods orderGoods){
        LoginUser user = SessionUtil.getUser();
        orderGoods.setUserId(user.getId());
        orderGoods.setUserName(user.getShowname());
        String orderNo = OrderUtil.getOrderNo(user.getId());
        orderGoods.setOrderNo(orderNo);
        orderGoods.setCreateTime(new Date());
        orderGoods.setStatus("1");

        OrderTime orderTime = new OrderTime();
        orderTime.setOrderNo(orderNo);
        orderTime.setStatusTime(new Date());
        orderGoods.setCreateTime(new Date());
        orderTime.setStatus("1");
        int add = orderGoodsService.insert(orderGoods);
        orderTimeService.insert(orderTime);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Msg update(OrderGoods orderGoods){
        int update = orderGoodsService.update(orderGoods);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Msg delete(Integer id){
        int delete = orderGoodsService.delete(id);
        return Msg.success();
    }
}
