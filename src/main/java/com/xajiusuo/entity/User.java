package com.xajiusuo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017-6-13.
 */
@Entity
@Table(name = "basic_user")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer", "depart"})
public class User implements Serializable {
    @Id
    //IDENTITY 对应mysql，oracle中使用SEQUENCE
//    @GeneratedValue(strategy = GenerationType.IDENTITY) -- TABLE
    //generator指定到具体的generator，TableGenerator中的name为别名，这里关联；还有初始值，增值
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user")
    @TableGenerator(name = "user", initialValue = 0, allocationSize = 1)
    private int ID;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "sex", length = 10)
    private String sex;
    @Column(name = "birth", length = 10)
    private String birth;
    @Column(name = "idcard", length = 20)
    private String idcard;
    @Column(name = "telephone", length = 30)
    private String telephone;
    @Column(name = "address")
    private String address;

    //jackson转换json的时候忽略该字段,因为是懒加载如果不忽略会报错
//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "departid")//默认不填JoinColumn会自动生成一个外键字段
    private Depart depart;
//    @Column(name = "roleid")
//    private Role role;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Depart getDepart() {
        return depart;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }

    @Override
    public String toString() {
        String toString = "Name:" + (this.name == null ? "" : this.name);
        toString += ",Sex:" + (this.sex == null ? "" : this.sex);
        toString += ",birth:" + (this.birth == null ? "" : this.birth);
        toString += ",idcard:" + (this.idcard == null ? "" : this.idcard);
        toString += ",telephone:" + (this.telephone == null ? "" : this.telephone);
        toString += ",address:" + (this.address == null ? "" : this.address);
        return toString;
    }
}
