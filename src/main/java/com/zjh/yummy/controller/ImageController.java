package com.zjh.yummy.controller;

import com.zjh.yummy.common.FilenameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
public class ImageController {


    /**
     * 上传图片
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadImage")
    @ResponseBody
    public String upload(@RequestPart("file") MultipartFile picture,HttpServletRequest request) {

        String pictureName = UUID.randomUUID().toString() + "." + FilenameUtil.getFileSuffix(picture.getOriginalFilename());
        try {
            String fileSavePath = request.getServletContext().getRealPath("/") + "images";
            picture.transferTo(new File(fileSavePath , pictureName));
        } catch (Exception e) {
            //
        }
        return "images/"+pictureName;
    }


}
