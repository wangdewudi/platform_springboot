package com.wcxy.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * (Unread)实体类
 *
 * @author makejava
 * @since 2020-07-17 14:31:12
 */
@Data
@Table(name = "unread")
public class Unread implements Serializable {
    private static final long serialVersionUID = -81367488252741609L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="uid")
    private String uid;

    @Column(name="unreadLove")
    private Integer unreadLove;

    @Column(name="unreadComment")
    private Integer unreadComment;

    @Column(name="unreadFollow")
    private Integer unreadFollow;

    @Column(name="unreadFans")
    private Integer unreadFans;



    @Column(name="time")
    private Date time;

}