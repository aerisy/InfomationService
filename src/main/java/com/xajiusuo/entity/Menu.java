package com.xajiusuo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by Administrator on 2017-6-19.
 */
@Entity
@Table(name = "basic_menu")
public class Menu {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String ID;
    private String name;
    private String url;
//    private Set<MenuDao> children;
}
