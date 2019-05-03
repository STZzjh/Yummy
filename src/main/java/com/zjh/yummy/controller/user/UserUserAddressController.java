package com.zjh.yummy.controller.user;

import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.SessionUtil;
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
@RequestMapping("user/user_address")
public class UserUserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    private String prefix = "user/user_address/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "user_address";
    }

    @RequestMapping(value = "user_address_add",method = RequestMethod.GET)
    public String pageAdd(Model model){
        return prefix + "user_address_add";
    }

    @RequestMapping(value = "user_address_edit", method = RequestMethod.GET)
    public String pageEdit(Model model, Integer id) {
        UserAddress userAddress = userAddressService.getById(id);
        model.addAttribute("item", userAddress);
        return prefix + "user_address_edit";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        query.and("user_id=", SessionUtil.getUser().getId());
        BTableData data = userAddressService.page(query);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(UserAddress userAddress){
        LoginUser user = SessionUtil.getUser();
        userAddress.setUserId(user.getId());
        userAddress.setUserName(user.getShowname());
        int add = userAddressService.insert(userAddress);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Msg update(UserAddress userAddress){
        int update = userAddressService.update(userAddress);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Msg delete(Integer id){
        int delete = userAddressService.delete(id);
        return Msg.success();
    }
}
