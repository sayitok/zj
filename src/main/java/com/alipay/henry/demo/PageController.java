/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.henry.demo;

import com.alipay.henry.demo.model.GxyDO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Henry
 * @version $Id: PageController.java, v 0.1 2018-07-29 下午3:54 Henry Exp $$
 */
@Controller
public class PageController {

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


    @RequestMapping(value = "/fillForm", method = RequestMethod.POST)
    public String handleGxy(@RequestBody GxyDO gxyDO) {
        return "";
    }
}