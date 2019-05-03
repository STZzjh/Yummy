package com.zjh.yummy.controller.admin;

import com.zjh.yummy.entity.Dict;
import com.zjh.yummy.service.DictService;
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
@RequestMapping("admin/dict")
public class AdminDictController {

    @Autowired
    private DictService dictService;
    private String prefix = "admin/dict/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return prefix + "dict";
    }

    @RequestMapping(value = "dict_add",method = RequestMethod.GET)
    public String pageAdd(){
        return prefix + "dict_add";
    }

    @RequestMapping(value = "dict_edit", method = RequestMethod.GET)
    public String pageEdit(Model model, Integer id) {
        Dict dict = dictService.getById(id);
        model.addAttribute("item", dict);
        return prefix + "dict_edit";
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BTableData list(SimpleQuery query){
        BTableData data = dictService.page(query);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Msg add(Dict dict){
        int add = dictService.insert(dict);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Msg update(Dict dict){
        int update = dictService.update(dict);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Msg delete(Integer id){
        int delete = dictService.delete(id);
        return Msg.success();
    }
}
