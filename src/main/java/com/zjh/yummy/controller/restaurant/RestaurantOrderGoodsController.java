package com.zjh.yummy.controller.restaurant;

import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.SessionUtil;
import com.zjh.yummy.entity.OrderGoods;
import com.zjh.yummy.service.OrderGoodsService;
import com.zjh.yummy.entity.User;
import com.zjh.yummy.service.UserService;
import com.zjh.yummy.entity.Goods;
import com.zjh.yummy.service.GoodsService;
import com.zjh.yummy.entity.UserAddress;
import com.zjh.yummy.service.UserAddressService;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.common.web.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("restaurant/order_goods")
public class RestaurantOrderGoodsController {

    @Autowired
    private OrderGoodsService orderGoodsService;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserAddressService userAddressService;

    private String prefix = "restaurant/order_goods/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "order_goods";
    }


    @RequestMapping(value = "order_goods_edit", method = RequestMethod.GET)
    public String pageEdit(Model model, Integer id) {
        OrderGoods orderGoods = orderGoodsService.getById(id);
        model.addAttribute("item", orderGoods);
        List<Goods> goodsList = goodsService.findList(null);
        List<UserAddress> userAddressList = userAddressService.findList(null);
        model.addAttribute("goodsList", goodsList);
        model.addAttribute("userAddressList", userAddressList);
        return prefix + "order_goods_edit";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        query.and("restaurant_id=", SessionUtil.getUser().getId());
        BTableData data = orderGoodsService.page(query);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(OrderGoods orderGoods){
        LoginUser user = SessionUtil.getUser();
        orderGoods.setRestaurantId(user.getId());
        orderGoods.setRestaurantName(user.getShowname());
        int add = orderGoodsService.insert(orderGoods);
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
