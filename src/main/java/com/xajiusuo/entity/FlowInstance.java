package com.xajiusuo.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017-6-19.
 */
@Entity
@Table(name = "basic_flowinstance")
public class FlowInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "flowInstance")
    @TableGenerator(name = "flowInstance", initialValue = 0, allocationSize = 1)
    private int ID;
    private int flow;
    private int curStep;
}
