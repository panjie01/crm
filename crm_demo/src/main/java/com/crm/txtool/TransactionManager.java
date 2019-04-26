package com.crm.txtool;



import com.crm.entity.Employee;
import com.crm.entity.Systemlog;
import com.crm.entity.UserContext;
import com.crm.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * 添加日志
 */
public class TransactionManager {

    @Autowired
    private EmployeeService service;

    public void txPointCut(){

    }

    public void addLog(JoinPoint point) {

        if (point.getTarget() instanceof EmployeeService)
            return;

        System.out.println("添加日志......");
        Systemlog log = new Systemlog();
        HttpServletRequest request = UserContext.getRequest();
        log.setOpiop(request.getRemoteAddr());
        log.setOpuser((Employee) request.getSession().getAttribute(UserContext.USERINSESSION));
        log.setOptime(new Date());

//        String function = point.getTarget().getClass().getName()+":"+point.getSignature().getName();
//        log.setFunction(function);
        /*try{
            ObjectMapper mapper = new ObjectMapper();
            String params = mapper.writeValueAsString(point.getArgs());
            log.setParams(params);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }*/
        //因为此时又会切sevcie方法 防止死循环

        System.out.println(log);
        service.addLog(log);
    }

    public void begin() {
        System.out.println("开启事务。。。");
    }

    public void commit() {
        System.out.println("提交事务。。。");
    }

    public void rollback(Exception tx) {
        System.out.println("回滚。。。");
    }

    public Object around(ProceedingJoinPoint proceed) {
        Object retval=null;
        System.out.println("执行环绕方法");
        try {
            retval=proceed.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return retval;
    }

}
