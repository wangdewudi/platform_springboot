package com.wcxy.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * (Forward)实体类
 *
 * @author makejava
 * @since 2020-07-17 14:31:07
 */
@Data
@Table(name = "collection")
public class Collection implements Serializable {
    private static final long serialVersionUID = -25247504411409787L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="msgId")
    private String msgId;

    @Column(name="collectionuid")
    private String collectionuid;

    @Column(name="time")
    private Date time;

//    @Column(name="check")
//    private String check;
//
//    @Column(name="createUid")
//    private String createUid;
//
//    @Column(name="schoolCode")
//    private String schoolCode;




}