package com.zjh.yummy.controller.user;

import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.SessionUtil;
import com.zjh.yummy.entity.Goods;
import com.zjh.yummy.service.GoodsService;
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
@RequestMapping("user/goods")
public class UserGoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private GoodsTypeService goodsTypeService;

    private String prefix = "user/goods/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "goods";
    }

    @RequestMapping(value = "goods_add",method = RequestMethod.GET)
    public String pageAdd(Model model){
        List<Restaurant> restaurantList = restaurantService.findList(null);
        List<GoodsType> goodsTypeList = goodsTypeService.findList(null);
        model.addAttribute("restaurantList", restaurantList);
        model.addAttribute("goodsTypeList", goodsTypeList);
        return prefix + "goods_add";
    }

    @RequestMapping(value = "goods_edit", method = RequestMethod.GET)
    public String pageEdit(Model model, Integer id) {
        Goods goods = goodsService.getById(id);
        model.addAttribute("item", goods);
        List<Restaurant> restaurantList = restaurantService.findList(null);
        List<GoodsType> goodsTypeList = goodsTypeService.findList(null);
        model.addAttribute("restaurantList", restaurantList);
        model.addAttribute("goodsTypeList", goodsTypeList);
        return prefix + "goods_edit";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        BTableData data = goodsService.page(query);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(Goods goods){
        int add = goodsService.insert(goods);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Msg update(Goods goods){
        int update = goodsService.update(goods);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Msg delete(Integer id){
        int delete = goodsService.delete(id);
        return Msg.success();
    }
}
