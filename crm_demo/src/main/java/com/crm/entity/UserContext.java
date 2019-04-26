package com.crm.entity;

import javax.servlet.http.HttpServletRequest;

public class UserContext {
    public static final String USERINSESSION = "USER_IN_SESSION";
    public static ThreadLocal<HttpServletRequest> local = new ThreadLocal<>();
    public static void setRequest(HttpServletRequest request){
        local.set(request);
    }
    public static HttpServletRequest getRequest(){
        return local.get();
    }
}
