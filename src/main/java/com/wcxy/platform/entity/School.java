package com.wcxy.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (School)实体类
 *
 * @author makejava
 * @since 2020-07-17 14:31:10
 */
@Data
@Table(name = "school")
public class School implements Serializable {
    private static final long serialVersionUID = 816567983838746547L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="schoolCode")
    private String schoolCode;

    @Column(name="school")
    private String school;

    @Column(name="province")
    private String province;

    @Column(name="city")
    private String city;

    @Column(name="initials")
    private String initials;




}