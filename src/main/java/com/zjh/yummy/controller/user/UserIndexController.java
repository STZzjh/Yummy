package com.zjh.yummy.controller.user;

import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.Msg;
import com.zjh.yummy.common.web.SessionUtil;
import com.zjh.yummy.entity.User;
import com.zjh.yummy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserIndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","","index"},method = RequestMethod.GET)
    public String index(){
        return "user/index";
    }

    @RequestMapping(value = "welcome",method = RequestMethod.GET)
    public String welcome(){
        return "user/welcome";
    }

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Model model) {
        LoginUser user = SessionUtil.getUser();
        User item = userService.getById(user.getId());
        model.addAttribute("item", item);
        return "user/profile";
    }

    @RequestMapping(value = "password", method = RequestMethod.GET)
    public String password() {
        return "user/password";
    }

    @ResponseBody
    @RequestMapping(value = "profile/update", method = RequestMethod.POST)
    public Msg profile(User user) {
        LoginUser local = SessionUtil.getUser();
        user.setId(local.getId());
        user.setPassword(null);
        user.setUsername(null);
        userService.update(user);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "password/update", method = RequestMethod.POST)
    public Msg passwordUpdate(String newpwd,String old) {
        LoginUser local = SessionUtil.getUser();
        User item = userService.getById(local.getId());
        if(!item.getPassword().equals(old)){
            Msg error = Msg.error();
            error.setMsg("原密码错误");
            return error;
        }

        User save = new User();
        save.setId(local.getId());
        save.setPassword(newpwd);
        userService.update(save);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Msg delete(Model model){
        LoginUser user = SessionUtil.getUser();
        User update = new User();
        update.setId(user.getId());
        update.setStatus("3");
        userService.update(update);
        return Msg.success();
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deletePage(Model model){
        return "user/delete";
    }

    @RequestMapping(value = "activate", method = RequestMethod.GET)
    public String activate(String token,String code,Model model){

        SimpleQuery query =  new SimpleQuery();
        query.and("username=", token).and("vcode=", code);
        List list = userService.findList(query);
        String msg = "激活失败";
        if(list!=null && list.size()==1){
            User updateUser = (User) list.get(0);
            User uUser = new User();
            uUser.setId(updateUser.getId());
            uUser.setStatus("2");
            userService.update(uUser);
            msg = "激活成功";
        }
        model.addAttribute("msg",msg);
        return "/login";
    }
}
