package com.zjh.yummy.controller;

import com.zjh.yummy.common.web.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Controller
public class FileController {


    /**
     * 上传图片
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile")
    @ResponseBody
    public Msg upload(@RequestPart("file") MultipartFile picture, HttpServletRequest request) {

        try {
            Properties properties = new Properties();
            properties.load(picture.getInputStream());
            String partNumber = (String) properties.get("PartNumber");
            String amendment = (String) properties.get("Amendment");
            String partDesignation = (String) properties.get("PartDesignation");
            Map<String, String> object = new HashMap<>();
            object.put("partNumber", partNumber);
            object.put("amendment", amendment);
            object.put("partDesignation", partDesignation);
            Msg success = Msg.success();
            return success.setData(object);
        } catch (Exception e) {
            //
        }
        return Msg.error();
    }

}

