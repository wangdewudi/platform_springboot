package com.wcxy.platform.entity;

import lombok.Data;
import tk.mybatis.mapper.entity.IDynamicTableName;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "messagelabel")
public class Messagelabel implements Serializable  {
    private static final long serialVersionUID = -84539719133145187L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="msgId")
    private String msgId;

    @Column(name="label")
    private String label;

    @Column(name="schoolCode")
    private String schoolCode;

//    private static String schoolCode;
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
