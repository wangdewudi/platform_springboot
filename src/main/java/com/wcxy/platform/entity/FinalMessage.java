package com.wcxy.platform.entity;

import lombok.Data;

import java.util.List;

@Data
public class FinalMessage {

    private Message message;

    private MessageContent messageContent;

    private List<Messagelabel> labellist;

    private List<Messagefile> filelist;

    private Resuser resuser;

    private String name;

    private Boolean islove;

    private List<FinalComment> finalComments;

}
