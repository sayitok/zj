/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.henry.demo;

import com.alipay.henry.demo.dao.GxyMapper;
import com.alipay.henry.demo.model.GxyDO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author Henry
 * @version $Id: PageController.java, v 0.1 2018-07-29 下午3:54 Henry Exp $$
 */
@Controller
public class PageController {

    @Resource
    private GxyMapper gxyMapper;

    /**
     * for home page
     * @param model
     * @return
     */
    @GetMapping("/test")
    public String homePage(Model model) {
        model.addAttribute("title","title=hello gxy");
        return "gxy";
    }


    @PostMapping("/fillForm")
    public String handleGxy(@RequestParam Map<String, String> body,Model model) {
        String msg = "success";
        String id = null;
        try {
            GxyDO gxyDO = convertToGxyDO(body);
            gxyMapper.insert(gxyDO);
            id = gxyDO.getId();
        } catch (Exception e) {
            msg = e.toString();
        }
        model.addAttribute("id",id);
        model.addAttribute("result", msg);
        return "result";
    }

    @PostMapping("/upload")
    public String  fileUpload2(@RequestParam("id") String id,
                               @RequestParam MultipartFile file,
                               Model model) throws IOException {
        String msg = "success";

        try {
            if(id==null) {
                id = String.valueOf(System.currentTimeMillis());
            }
            String path="/root/ftp/" + id + "_" + file.getOriginalFilename();

            File newFile=new File(path);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
        } catch (Exception e) {
            msg = e.toString();
        }
        model.addAttribute("result", msg);
        return "result2";
    }


    private GxyDO convertToGxyDO(Map<String, String> body) {
        GxyDO gxyDO = new GxyDO();

        try {
            Field[] fileds = GxyDO.class.getDeclaredFields();
            for(Field field:fileds) {
                String name = field.getName();
                Object value = parseValue(field.getType(), name, body);
                if(value==null) {
                    continue;
                }
                field.setAccessible(true);
                field.set(gxyDO,value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        gxyDO.setId(String.valueOf(System.currentTimeMillis()));
        return gxyDO;
    }


    private Object parseValue(Class type, String name, Map<String,String> body) throws ParseException {
        String obj = body.get(name);
        if(obj==null||obj.equals("")) {
            return null;
        }
        if("gender".equals(name)) {
            return "男".equals(obj)?1:0;
        }
        if("birthday".equals(name) || "ckdDate".equals(name)) {
            return parseDate(obj);
        }
        if(type == Integer.TYPE) {
            return Integer.parseInt(obj);
        }
        if(type == Double.TYPE) {
            return Double.parseDouble(obj);
        }
        return obj;
    }

    private Date parseDate(String obj) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(obj);
    }

}