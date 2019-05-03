package com.zjh.yummy.controller.restaurant;

import com.zjh.yummy.entity.GoodsGoods;
import com.zjh.yummy.service.GoodsGoodsService;
import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.BTableData;
import com.zjh.yummy.common.web.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("restaurant/goods_goods")
public class RestaurantGoodsGoodsController {

    @Autowired
    private GoodsGoodsService goodsGoodsService;
    private String prefix = "restaurant/goods_goods/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "goods_goods";
    }

    @RequestMapping(value = "goods_goods_add",method = RequestMethod.GET)
    public String pageAdd(){
        return prefix + "goods_goods_add";
    }

    @RequestMapping(value = "goods_goods_edit", method = RequestMethod.GET)
    public String pageEdit(Model model, Integer id) {
        GoodsGoods goodsGoods = goodsGoodsService.getById(id);
        model.addAttribute("item", goodsGoods);
        return prefix + "goods_goods_edit";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        BTableData data = goodsGoodsService.page(query);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(GoodsGoods goodsGoods){
        int add = goodsGoodsService.insert(goodsGoods);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Msg update(GoodsGoods goodsGoods){
        int update = goodsGoodsService.update(goodsGoods);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Msg delete(Integer id){
        int delete = goodsGoodsService.delete(id);
        return Msg.success();
    }
}
