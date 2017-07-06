package com.xajiusuo.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017-6-21.
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    private Date createTime;
    private Date updateTime;
    private User user;
}
