package com.wcxy.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "suggestion")
public class Suggestion implements Serializable {
    private static final long serialVersionUID = -25247504411409787L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "content")
    private String content;

    @Column(name = "imgfile1")
    private String imgfile1;

    @Column(name = "imgfile2")
    private String imgfile2;

    @Column(name = "time")
    private Date time;


}
