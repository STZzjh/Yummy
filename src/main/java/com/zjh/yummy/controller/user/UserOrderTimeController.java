package com.zjh.yummy.controller.user;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user/order_time")
public class UserOrderTimeController {

    @Autowired
    private OrderTimeService orderTimeService;

    private String prefix = "user/order_time/";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model,String orderNo) {
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
        query.and("order_no=", orderNo);
        BTableData data = orderTimeService.page(query);
        return data;
    }

    /**
     * 支付
     * @param orderNo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "pay",method = RequestMethod.POST)
    public Msg pay(String orderNo){
        OrderTime orderTime = new OrderTime();
        orderTime.setCreateTime(new Date());
        orderTime.setStatus("2");
        orderTime.setOrderNo(orderNo);
        orderTime.setStatusTime(new Date());
        int add = orderTimeService.insert(orderTime);
        return Msg.success();
    }

    /*
    * 确认收货
    * */
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(String orderNo){
        OrderTime orderTime = new OrderTime();
        orderTime.setCreateTime(new Date());
        orderTime.setStatus("4");
        orderTime.setOrderNo(orderNo);
        orderTime.setStatusTime(new Date());
        int add = orderTimeService.insert(orderTime);
        return Msg.success();
    }

    /**
     * 退订
     * @param orderNo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Msg update(String orderNo){
        OrderTime orderTime = new OrderTime();
        orderTime.setCreateTime(new Date());
        orderTime.setStatus("5");
        orderTime.setOrderNo(orderNo);
        orderTime.setStatusTime(new Date());
        int add = orderTimeService.insert(orderTime);
        return Msg.success();
    }

    /**
     * 取消
     * @param orderNo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Msg delete(String orderNo){
        OrderTime orderTime = new OrderTime();
        orderTime.setCreateTime(new Date());
        orderTime.setStatus("6");
        orderTime.setOrderNo(orderNo);
        orderTime.setStatusTime(new Date());
        int add = orderTimeService.insert(orderTime);
        return Msg.success();
    }
}
