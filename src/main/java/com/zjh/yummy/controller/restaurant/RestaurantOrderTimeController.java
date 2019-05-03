package com.zjh.yummy.controller.restaurant;

import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.SessionUtil;
import com.zjh.yummy.entity.OrderTime;
import com.zjh.yummy.service.OrderTimeService;
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

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("restaurant/order_time")
public class RestaurantOrderTimeController {

    @Autowired
    private OrderTimeService orderTimeService;

    private String prefix = "restaurant/order_time/";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(String orderNo, Model model) {
        model.addAttribute("orderNo", orderNo);
        return prefix + "order_time";
    }

    @RequestMapping(value = "order_time_add",method = RequestMethod.GET)
    public String pageAdd(Model model){
        return prefix + "order_time_add";
    }

    @RequestMapping(value = "order_time_edit", method = RequestMethod.GET)
    public String pageEdit(Model model, Integer id) {
        OrderTime orderTime = orderTimeService.getById(id);
        model.addAttribute("item", orderTime);
        return prefix + "order_time_edit";
    }

    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public BTableData list(SimpleQuery query, String orderNo) {
        if (StringUtils.isEmpty(orderNo)) {
            return new BTableData();
        }
        query.and("order_no=", orderNo);
        BTableData data = orderTimeService.page(query);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(OrderTime orderTime){
        orderTime.setCreateTime(new Date());
        orderTime.setStatus("3");
        orderTime.setStatusTime(new Date());
        int add = orderTimeService.insert(orderTime);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Msg update(OrderTime orderTime){
        int update = orderTimeService.update(orderTime);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Msg delete(Integer id){
        int delete = orderTimeService.delete(id);
        return Msg.success();
    }
}
