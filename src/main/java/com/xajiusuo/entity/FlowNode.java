package com.xajiusuo.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017-6-19.
 */
@Entity
@Table(name = "basic_flownode")
public class FlowNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "flownode")
    @TableGenerator(name = "flownode", initialValue = 0, allocationSize = 1)
    private int ID;
    private String stepName;
    private int step;
    //授权角色 ID
    private String inRole;
    //授权用户 ID
    private String inUser;
}
