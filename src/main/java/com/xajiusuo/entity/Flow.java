package com.xajiusuo.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017-6-19.
 */
@Entity
@Table(name = "basic_flow")
public class Flow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "flow")
    @TableGenerator(name = "flow", initialValue = 0, allocationSize = 1)
    private int ID;
    private String name;
    @Column(name="\"desc\"")
    private String desc;
}
