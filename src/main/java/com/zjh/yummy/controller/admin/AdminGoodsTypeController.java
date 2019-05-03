package com.zjh.yummy.controller.admin;

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

@Controller
@RequestMapping("admin/goods_type")
public class AdminGoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;
    private String prefix = "admin/goods_type/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "goods_type";
    }

    @RequestMapping(value = "goods_type_add",method = RequestMethod.GET)
    public String pageAdd(){
        return prefix + "goods_type_add";
    }

    @RequestMapping(value = "goods_type_edit", method = RequestMethod.GET)
    public String pageEdit(Model model, Integer id) {
        GoodsType goodsType = goodsTypeService.getById(id);
        model.addAttribute("item", goodsType);
        return prefix + "goods_type_edit";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        BTableData data = goodsTypeService.page(query);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(GoodsType goodsType){
        int add = goodsTypeService.insert(goodsType);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Msg update(GoodsType goodsType){
        int update = goodsTypeService.update(goodsType);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Msg delete(Integer id){
        int delete = goodsTypeService.delete(id);
        return Msg.success();
    }
}
