package com.zjh.yummy.controller.user;

import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.SessionUtil;
import com.zjh.yummy.entity.Recharge;
import com.zjh.yummy.service.RechargeService;
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
@RequestMapping("user/recharge")
public class UserRechargeController {

    @Autowired
    private RechargeService rechargeService;

    private String prefix = "user/recharge/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "recharge";
    }

    @RequestMapping(value = "recharge_add",method = RequestMethod.GET)
    public String pageAdd(Model model){
        return prefix + "recharge_add";
    }

    @RequestMapping(value = "recharge_edit", method = RequestMethod.GET)
    public String pageEdit(Model model, Integer id) {
        Recharge recharge = rechargeService.getById(id);
        model.addAttribute("item", recharge);
        return prefix + "recharge_edit";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        query.and("user_id=", SessionUtil.getUser().getId());
        BTableData data = rechargeService.page(query);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(Recharge recharge){
        LoginUser user = SessionUtil.getUser();
        recharge.setUserId(user.getId());
        recharge.setUserName(user.getShowname());
        recharge.setCreateTime(new Date());
        int add = rechargeService.insert(recharge);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Msg update(Recharge recharge){
        int update = rechargeService.update(recharge);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Msg delete(Integer id){
        int delete = rechargeService.delete(id);
        return Msg.success();
    }
}
