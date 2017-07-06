package com.xajiusuo.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017-6-19.
 */
@Entity
@Table(name = "basic_operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "operation")
    @TableGenerator(name = "operation", initialValue = 0, allocationSize = 1)
    private int ID;
    private String name;
    @Column(name="\"desc\"")
    private String desc;
    //操作代码，唯一
    private String opCode;
}
