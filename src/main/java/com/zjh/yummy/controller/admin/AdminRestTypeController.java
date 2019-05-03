package com.zjh.yummy.controller.admin;

import com.zjh.yummy.entity.RestType;
import com.zjh.yummy.service.RestTypeService;
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
@RequestMapping("admin/rest_type")
public class AdminRestTypeController {

    @Autowired
    private RestTypeService restTypeService;
    private String prefix = "admin/rest_type/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "rest_type";
    }

    @RequestMapping(value = "rest_type_add",method = RequestMethod.GET)
    public String pageAdd(){
        return prefix + "rest_type_add";
    }

    @RequestMapping(value = "rest_type_edit", method = RequestMethod.GET)
    public String pageEdit(Model model, Integer id) {
        RestType restType = restTypeService.getById(id);
        model.addAttribute("item", restType);
        return prefix + "rest_type_edit";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        BTableData data = restTypeService.page(query);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(RestType restType){
        int add = restTypeService.insert(restType);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Msg update(RestType restType){
        int update = restTypeService.update(restType);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Msg delete(Integer id){
        int delete = restTypeService.delete(id);
        return Msg.success();
    }
}
