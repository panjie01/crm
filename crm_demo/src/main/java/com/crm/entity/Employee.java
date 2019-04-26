package com.crm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Employee {
    private Integer id;
    private String name;
    private Department depart;
}
