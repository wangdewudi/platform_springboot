package com.wcxy.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (UserRank)实体类
 *
 * @author makejava
 * @since 2020-07-17 14:31:14
 */
@Data
@Table(name = "userrank")
public class UserRank implements Serializable {
    private static final long serialVersionUID = 943622344889979708L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="uid")
    private String uid;

    @Column(name="numberFans")
    private Integer numberFans;

    @Column(name="numberFollow")
    private Integer numberFollow;

    @Column(name="numberLove")
    private Integer numberLove;

    @Column(name="numberComment")
    private Integer numberComment;


    @Column(name="numberMessage")
    private Integer numberMessage;

    @Column(name="numberCollection")
    private Integer numberCollection;
}