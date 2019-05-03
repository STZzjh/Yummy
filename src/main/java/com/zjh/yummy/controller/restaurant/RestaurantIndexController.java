package com.zjh.yummy.controller.restaurant;

import com.zjh.yummy.common.web.LoginUser;
import com.zjh.yummy.common.web.Msg;
import com.zjh.yummy.common.web.SessionUtil;
import com.zjh.yummy.entity.Restaurant;
import com.zjh.yummy.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("restaurant")
public class RestaurantIndexController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = {"/","","index"},method = RequestMethod.GET)
    public String index(){
        return "restaurant/index";
    }

    @RequestMapping(value = "welcome",method = RequestMethod.GET)
    public String welcome(){
        return "restaurant/welcome";
    }

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Model model) {
        LoginUser restaurant = SessionUtil.getUser();
        Restaurant item = restaurantService.getById(restaurant.getId());
        model.addAttribute("item", item);
        return "restaurant/profile";
    }

    @RequestMapping(value = "password", method = RequestMethod.GET)
    public String password() {
        return "restaurant/password";
    }

    @ResponseBody
    @RequestMapping(value = "profile/update", method = RequestMethod.POST)
    public Msg profile(Restaurant restaurant) {
        LoginUser local = SessionUtil.getUser();
        restaurant.setId(local.getId());
        restaurant.setPassword(null);
        restaurant.setLoginNo(null);
        restaurant.setStatus("0");
        restaurantService.update(restaurant);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "password/update", method = RequestMethod.POST)
    public Msg passwordUpdate(String newpwd,String old) {
        LoginUser local = SessionUtil.getUser();
        Restaurant item = restaurantService.getById(local.getId());
        if(!item.getPassword().equals(old)){
            Msg error = Msg.error();
            error.setMsg("原密码错误");
            return error;
        }

        Restaurant save = new Restaurant();
        save.setId(local.getId());
        save.setPassword(newpwd);
        restaurantService.update(save);
        return Msg.success();
    }
}
