package com.zjh.yummy.controller.admin;

import com.zjh.yummy.entity.Restaurant;
import com.zjh.yummy.service.RestaurantService;
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
@RequestMapping("admin/restaurant")
public class AdminRestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    private String prefix = "admin/restaurant/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "restaurant";
    }

    @RequestMapping(value = "restaurant_add",method = RequestMethod.GET)
    public String pageAdd(){
        return prefix + "restaurant_add";
    }

    @RequestMapping(value = "restaurant_edit", method = RequestMethod.GET)
    public String pageEdit(Model model, Integer id) {
        Restaurant restaurant = restaurantService.getById(id);
        model.addAttribute("item", restaurant);
        return prefix + "restaurant_edit";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        BTableData data = restaurantService.page(query);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(Restaurant restaurant){
        int add = restaurantService.insert(restaurant);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Msg update(Restaurant restaurant){
        int update = restaurantService.update(restaurant);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Msg delete(Integer id){
        int delete = restaurantService.delete(id);
        return Msg.success();
    }
}
