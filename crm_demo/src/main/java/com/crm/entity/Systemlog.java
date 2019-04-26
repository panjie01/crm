package com.crm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Setter
@Getter
@ToString
public class Systemlog {
    private String opiop;
    private Employee opuser;
    private Date optime;
    private String function;
    private String params;
}
