package com.wcxy.platform.entity;

import lombok.Data;
import tk.mybatis.mapper.entity.IDynamicTableName;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * (Comment)实体类
 *
 * @author makejava
 * @since 2020-07-17 14:31:05
 */
@Data
@Table(name = "comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = -91060582706910726L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="msgId")
    private String msgId;

    @Column(name="commentId")
    private String commentId;

    @Column(name="uid")
    private String uid;

    @Column(name="replycommentId")
    private String replycommentId;

    @Column(name="atId")
    private String atId;

    @Column(name="numberLove")
    private Integer numberLove;

    @Column(name="content")
    private String content;

    @Column(name="numberComment")
    private Integer numberComment;

    @Column(name="timeSend")
    private Date timeSend;

    @Column(name = "checked")
    private  String checked;

//    @Column(name="schoolCode")
//    private String schoolCode;
//
//
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