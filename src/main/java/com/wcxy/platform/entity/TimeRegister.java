package com.wcxy.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * (TimeRegister)实体类
 *
 * @author makejava
 * @since 2020-07-17 14:31:11
 */
@Data
@Table(name = "timeregister")
public class TimeRegister implements Serializable {
    private static final long serialVersionUID = 353820526311224507L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="uid")
    private String uid;

    @Column(name="time")
    private Date time;




}