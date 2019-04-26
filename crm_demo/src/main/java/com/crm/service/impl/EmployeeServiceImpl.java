package com.crm.service.impl;

import com.crm.entity.Systemlog;
import com.crm.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void addLog(Systemlog log) {
        System.out.println("这是添加日志的方法");
    }
}
