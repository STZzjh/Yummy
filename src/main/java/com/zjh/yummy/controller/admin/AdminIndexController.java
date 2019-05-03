package com.zjh.yummy.controller.admin;

import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.Msg;
import com.zjh.yummy.common.web.SessionUtil;
import com.zjh.yummy.entity.Admin;
import com.zjh.yummy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class AdminIndexController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"/","","index"},method = RequestMethod.GET)
    public String index(){
        return "admin/index";
    }

    @RequestMapping(value = "welcome",method = RequestMethod.GET)
    public String welcome(){
        return "admin/welcome";
    }

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Model model) {
        LoginUser admin = SessionUtil.getUser();
        Admin item = adminService.getById(admin.getId());
        model.addAttribute("item", item);
        return "admin/profile";
    }

    @RequestMapping(value = "password", method = RequestMethod.GET)
    public String password(Model model, HttpServletRequest request) {
        return "admin/password";
    }

    @ResponseBody
    @RequestMapping(value = "profile/update", method = RequestMethod.POST)
    public Msg profile(Admin admin) {
        LoginUser local = SessionUtil.getUser();
        Admin save = new Admin();
        save.setId(local.getId());
        save.setIntro(admin.getIntro());
        adminService.update(save);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "password/update", method = RequestMethod.POST)
    public Msg passwordUpdate(String newpwd,String old) {
        LoginUser local = SessionUtil.getUser();
        Admin item = adminService.getById(local.getId());
        if(!item.getPassword().equals(old)){
            Msg error = Msg.error();
            error.setMsg("原密码错误");
            return error;
        }

        Admin save = new Admin();
        save.setId(local.getId());
        save.setPassword(newpwd);
        adminService.update(save);
        return Msg.success();
    }
}
