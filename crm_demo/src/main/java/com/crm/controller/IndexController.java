package com.crm.controller;

import com.crm.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("hello")
    public String index() {
        indexService.test();
        return "hello";
    }
}
