package com.wcxy.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * (FansDetail)实体类
 *
 * @author makejava
 * @since 2020-07-17 14:31:06
 */
@Data
@Table(name = "fansdetail")
public class FansDetail implements Serializable {
    private static final long serialVersionUID = 252239296422902476L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="uidFans")
    private String uidFans;

    @Column(name="uidFllower")
    private String uidFllower;

    @Column(name="checked")
    private String checked;

    @Column(name="time")
    private Date time;



}