package com.zjh.yummy.controller.user;

import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.SessionUtil;
import com.zjh.yummy.entity.Restaurant;
import com.zjh.yummy.service.RestaurantService;
import com.zjh.yummy.entity.GoodsType;
import com.zjh.yummy.service.GoodsTypeService;
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
@RequestMapping("user/restaurant")
public class UserRestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private GoodsTypeService goodsTypeService;

    private String prefix = "user/restaurant/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "restaurant";
    }

    @RequestMapping(value = "restaurant_add",method = RequestMethod.GET)
    public String pageAdd(Model model){
        List<GoodsType> goodsTypeList = goodsTypeService.findList(null);
        model.addAttribute("goodsTypeList", goodsTypeList);
        return prefix + "restaurant_add";
    }

    @RequestMapping(value = "restaurant_edit", method = RequestMethod.GET)
    public String pageEdit(Model model, Integer id) {
        Restaurant restaurant = restaurantService.getById(id);
        model.addAttribute("item", restaurant);
        List<GoodsType> goodsTypeList = goodsTypeService.findList(null);
        model.addAttribute("goodsTypeList", goodsTypeList);
        return prefix + "restaurant_edit";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        BTableData data = restaurantService.page(query);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(Restaurant restaurant){
        int add = restaurantService.insert(restaurant);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Msg update(Restaurant restaurant){
        int update = restaurantService.update(restaurant);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Msg delete(Integer id){
        int delete = restaurantService.delete(id);
        return Msg.success();
    }
}
