package com.zjh.yummy.controller.admin;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin/order_goods_pt")
public class AdminOrderGoodsPtController {

    @Autowired
    private OrderGoodsService orderGoodsService;
    private String prefix = "admin/order_goods_pt/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "order_goods_pt";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        OrderGoods orderGoods = orderGoodsService.adminCount(query);
        List<OrderGoods> list = new ArrayList<>();
        list.add(orderGoods);
        BTableData data = new BTableData();
        data.setRows(list);
        data.setTotal(list.size());
        return data;
    }

}
