package com.xajiusuo.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017-6-19.
 */
@Entity
@Table(name = "basic_diction")
public class Diction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "diction")
    @TableGenerator(name = "diction", initialValue = 0, allocationSize = 1)
    private int ID;
    private String name;
    private String key;
    private String value;

    private String desc;

    //父ID
    private int pid;
}
