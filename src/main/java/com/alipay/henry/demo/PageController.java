/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.henry.demo;

import com.alipay.henry.demo.dao.GxyMapper;
import com.alipay.henry.demo.model.GxyDO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public String homePage(ModelMap model) {
        model.addAttribute("title","title=hello gxy");
        return "gxy";
    }


//    @RequestMapping(value = "/fillForm", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
//            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @PostMapping
    public String handleGxy(@RequestParam Map<String, String> body,ModelMap model) {
        try {
            gxyMapper.insert(convertToGxyDO(body));
        } catch (Exception e) {
            model.addAttribute("result", e.toString());
        }
        return "result";
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