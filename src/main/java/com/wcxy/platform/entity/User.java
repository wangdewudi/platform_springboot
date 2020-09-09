package com.wcxy.platform.entity;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-07-17 14:31:13
 */
@Data
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 670656555708296384L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="uid")
    private String uid;

    @Column(name="openid")
    private String openid;

    @Column(name="qqopenid")
    private String qqopenid;

    @Column(name="phone")
    private String phone;

    @Column(name="nickname")
    private String nickname;

    @Column(name="sex")
    private String sex;

    @Column(name="headurl")
    private String headurl;



//    @Override
//    @Transient
//    public String getDynamicTableName (){
//        StringBuilder tableName=new StringBuilder(this.getClass().getAnnotation(Table.class).name());
//
//        if(type!=""){
//            try {
//
//                tableName = tableName.append("_").append(type);
//                return tableName.toString();
//            }
//            catch(Exception e){
//
//                System.out.println(e);
//            }
//        }
//
//        return tableName.toString();
//    }


}