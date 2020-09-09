package com.wcxy.platform.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "help")
public class Help {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "checked")
    private String checked;

}
