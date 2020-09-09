package com.wcxy.platform.entity;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.*;

/**
 * (Campus)实体类
 *
 * @author makejava
 * @since 2020-07-17 14:31:04
 */
@Data
@Table(name = "campus")
public class Campus implements Serializable {
    private static final long serialVersionUID = -84539719133145187L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="campusCode")
    private String campusCode;

    @Column(name="campus")
    private String campus;

    @Column(name="schoolCode")
    private String schoolCode;




}