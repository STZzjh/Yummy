package com.zjh.yummy.controller;

import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.common.web.Msg;
import com.zjh.yummy.entity.*;
import com.zjh.yummy.service.*;
import com.zjh.yummy.common.web.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestTypeService restTypeService;

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("loginUser", null);
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "register-rest", method = RequestMethod.GET)
    public String registerRest(Model model) {
        List<RestType> list = restTypeService.findList(null);
        model.addAttribute("restTypeList", list);
        return "admin/restaurant/restaurant_add";
    }

    @ResponseBody
    @RequestMapping(value = "register-rest", method = RequestMethod.POST)
    public Msg registerRest(Restaurant restaurant, Model model) {
        try {
            SimpleQuery simpleQuery = SimpleQuery.create();
            simpleQuery.setLimit(1);
            simpleQuery.setOffset(0);
            simpleQuery.setSort("id");
            simpleQuery.setOrder("desc");
            List<Restaurant> list = restaurantService.findList(simpleQuery);
            String loginNo = "CT00001";
            if (list != null && list.size() == 1) {
                Restaurant restaurant1 = list.get(0);
                Integer id = restaurant1.getId();
                int no = id + 1;
                String format = String.format("CT%05d", no);
                loginNo = format;
            }
            restaurant.setLoginNo(loginNo);
            restaurant.setPassword("123456");
            restaurant.setStatus("0");
            int add = restaurantService.insert(restaurant);
            Msg success = Msg.success();
            success.setMsg("申请成功，登录号："+loginNo+",密码：123456");
            return success;
        } catch (Exception e) {
            Msg error = Msg.error();
            error.setMsg("改社会信用代码已存在");
            return error;
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, Model model) {
        try {
            int add = userService.insert(user);
            if (add > 0) {
                model.addAttribute("msg", "注册成功，请登录");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("msg", "注册学号重复");
            return "register";
        }
        model.addAttribute("msg", "注册失败");
        return "register";
    }


    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String loginPost(
            HttpServletRequest request,
            String username, String password, String type,
                            Model model){
        if (type != null && !"".equals(type)) {
            if("admin".equals(type)){
                Admin admin = adminService.login(username);
                if(admin == null || !admin.getPassword().equals(password)){
                    model.addAttribute("msg", "用户名或密码错误");
                    return "login";
                }
                LoginUser loginUser = new LoginUser();
                loginUser.setId(admin.getId());
                loginUser.setRole("admin");
                loginUser.setShowname(admin.getName());
                loginUser.setUsername(admin.getUsername());
                request.getSession().setAttribute("loginUser", loginUser);
                return "redirect:/admin/index";
            }
            if("user".equals(type)){
                User login = userService.login(username);
                if(login == null || !login.getPassword().equals(password)){
                    model.addAttribute("msg", "用户名或密码错误");
                    return "login";
                }
                if("1".equals(login.getStatus())){
                    model.addAttribute("msg", "账号未激活");
                    return "login";
                }
                if("3".equals(login.getStatus())){
                    model.addAttribute("msg", "账号已注销");
                    return "login";
                }
                if(!"2".equals(login.getStatus())){
                    model.addAttribute("msg", "账号异常");
                    return "login";
                }
                LoginUser loginUser = new LoginUser();
                loginUser.setId(login.getId());
                loginUser.setRole("user");
                loginUser.setShowname(login.getName());
                loginUser.setUsername(login.getUsername());
                request.getSession().setAttribute("loginUser", loginUser);
                return "redirect:/user/index";
            }
            if("restaurant".equals(type)){
                Restaurant login = restaurantService.login(username);
                if(login == null || !login.getPassword().equals(password)){
                    model.addAttribute("msg", "用户名或密码错误");
                    return "login";
                }
                if("0".equals(login.getStatus())){
                    model.addAttribute("msg", "账号审批中");
                    return "login";
                }
                if("2".equals(login.getStatus())){
                    model.addAttribute("msg", "账号整顿");
                    return "login";
                }
                if(!"1".equals(login.getStatus())){
                    model.addAttribute("msg", "账号异常");
                    return "login";
                }
                LoginUser loginUser = new LoginUser();
                loginUser.setId(login.getId());
                loginUser.setRole("restaurant");
                loginUser.setShowname(login.getName());
                loginUser.setUsername(login.getLoginNo());
                request.getSession().setAttribute("loginUser", loginUser);
                return "redirect:/restaurant/index";
            }
        }
        return "login";
    }


}
