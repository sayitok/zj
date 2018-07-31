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
    public String handleGxy(@RequestParam Map<String, String> body) {
        gxyMapper.insert(convertToGxyDO(body));
        return "gxy";
    }


    private GxyDO convertToGxyDO(Map<String, String> body) {
        GxyDO gxyDO = new GxyDO();
        return gxyDO;
    }
}