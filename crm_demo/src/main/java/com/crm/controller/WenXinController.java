package com.crm.controller;


import com.crm.service.IndexService;
import com.crm.util.SecurityUtil;
import com.crm.util.WeiXinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * 用来进行微信测试
 */
@Controller
@RequestMapping("weixin")
public class WenXinController {


    @Autowired
    private IndexService indexService;

    @RequestMapping("test")
    @ResponseBody
    public String index(String signature,String timestamp,String nonce,String echostr) {
        System.out.println("参数："+signature+","+timestamp+","+nonce+","+echostr);
        String[] arr = {timestamp,nonce, WeiXinUtil.TOKEN};
        Arrays.sort(arr);
        String str = "";
        for (String s:arr){
            str += s;
        }

        if (SecurityUtil.SHA1(str).equals(signature)){
            System.out.println("验证通过......");
            return echostr;
        }

        System.out.println("验证不通过......");
        return null;
    }
}
