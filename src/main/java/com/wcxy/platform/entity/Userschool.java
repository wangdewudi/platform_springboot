package com.wcxy.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (UserSchool)实体类
 *
 * @author makejava
 * @since 2020-07-17 14:31:14
 */
@Data
@Table(name = "userschool")
public class Userschool implements Serializable {
    private static final long serialVersionUID = 880245296521074859L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="uid")
    private String uid;

    @Column(name="schoolCode")
    private String schoolCode;

    @Column(name="grade")
    private String grade;

    @Column(name="college")
    private String college;

    @Column(name="campusCode")
    private String campusCode;




}