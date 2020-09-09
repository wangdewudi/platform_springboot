package com.wcxy.platform.tools;

import com.github.pagehelper.PageInfo;
import com.wcxy.platform.entity.*;

import java.util.ArrayList;
import java.util.List;

public class Getpage {
   public  List<Message> getMessage(PageInfo<Message> info){
        List<Message> messages=new ArrayList<Message>();
        int i=0;

        for(;i<info.getSize();i++)
            messages.add(info.getList().get(i));

        return messages;
    }

    public  List<Comment> getComment(PageInfo<Comment> info){
        List<Comment> comments=new ArrayList<Comment>();
        int i=0;
        for(;i<info.getSize();i++)
            comments.add(info.getList().get(i));

        return comments;
    }

    public  List<Messagelabel> getMessagelabel(PageInfo<Messagelabel> info){
        List<Messagelabel> messagelabels=new ArrayList<Messagelabel>();
        int i=0;

        for(;i<info.getSize();i++)
            messagelabels.add(info.getList().get(i));

        return messagelabels;
    }
    public  List<School> getSchool(PageInfo<School> info){
        List<School> schools=new ArrayList<School>();
        int i=0;

        for(;i<info.getSize();i++)
            schools.add(info.getList().get(i));

        return schools;
    }

    public  List<Help> getHelp(PageInfo<Help> info){
        List<Help> helps=new ArrayList<Help>();
        int i=0;

        for(;i<info.getSize();i++)
            helps.add(info.getList().get(i));

        return helps;
    }
}
