package com.wcxy.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * (MessageloveList)实体类
 *
 * @author makejava
 * @since 2020-07-17 14:31:09
 */
@Data
@Table(name = "userlove")
public class UserLove implements Serializable {
    private static final long serialVersionUID = -80089076250810725L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="msgId")
    private String msgId;

    @Column(name="admirerUid")
    private String admirerUid;


    @Column(name="time")
    private Date time;

    @Column(name="uid")
    private String uid;

    @Column(name="type")
    private String type;

//    @Column(name="check")
//    private String check;
//
//    @Column(name="createUid")
//    private String createUid;
//
//    @Column(name="schoolCode")
//    private String schoolCode;


}