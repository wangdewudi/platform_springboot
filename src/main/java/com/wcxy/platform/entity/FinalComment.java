package com.wcxy.platform.entity;

import lombok.Data;

import java.util.List;

@Data
public class FinalComment {

    private Comment comment;

    private String nickname;

    private String headurl;

    private String atname;

    private Boolean islove;

    private List<FinalComment> finalComments;
}
