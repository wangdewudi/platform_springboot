package com.wcxy.platform.entity;

import lombok.Data;
import tk.mybatis.mapper.entity.IDynamicTableName;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * (Message)实体类
 *
 * @author makejava
 * @since 2020-07-17 14:31:08
 */
@Data
@Table(name = "message")
public class Message implements Serializable {
    private static final long serialVersionUID = -63119465168049795L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="msgId")
    private String msgId;

    @Column(name="uidCreate")
    private String uidCreate;

    @Column(name="uidSend")
    private String uidSend;

    @Column(name="sendmsgId")
    private String sendmsgId;

    @Column(name="numberLove")
    private Integer numberLove;

    @Column(name="numberBrowse")
    private Integer numberBrowse;

    @Column(name="numberForward")
    private Integer numberForward;

    @Column(name="numberComment")
    private String numberComment;

    @Column(name="timeSend")
    private Date timeSend;

    @Column(name="schoolCode")
    private String schoolCode;
//
//    public static String getSchoolCode() {
//        return schoolCode;
//    }
//
//    public static void setSchoolCode(String code) {
//        schoolCode = code;
//    }
//
//    @Override
//    @Transient
//    public String getDynamicTableName (){
//        StringBuilder tableName=new StringBuilder(this.getClass().getAnnotation(Table.class).name());
//
//        if(schoolCode!=""){
//            try {
//
//                tableName = tableName.append("_").append(schoolCode);
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