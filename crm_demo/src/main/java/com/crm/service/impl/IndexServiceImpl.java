package com.crm.service.impl;

import com.crm.service.IndexService;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {

    public void test(){
        System.out.println("这是 service 微信测试方法......");
    }
}
