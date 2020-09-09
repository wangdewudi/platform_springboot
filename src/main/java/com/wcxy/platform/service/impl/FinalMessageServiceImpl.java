package com.wcxy.platform.service.impl;

import com.wcxy.platform.entity.*;
import com.wcxy.platform.service.FinalMessageService;
import com.wcxy.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinalMessageServiceImpl implements FinalMessageService {

    @Autowired
    private  MessageServiceImpl messageService;

    @Autowired
    private MessageContentServiceImpl messageContentService;

    @Autowired
    private MessagefileServiceImpl messagefileService;

    @Autowired
    private MessagelabelServiceImpl messagelabelService;

    @Autowired
    private ResuserServiceImpl resuserservice;

    @Autowired
    private UserService userService;

    @Autowired
    private  FinalCommentServiceImpl finalCommentService;

    @Autowired
    private UserRankServiceImpl userRankService;

    @Autowired
    private  UserLoveServiceImpl userLoveService;

    @Autowired
    private  UnreadServiceImpl unreadService;

    private MessageContent messageContent;
    private List<Messagelabel> messagelabels;
    private List<Messagefile> messagefiles;
    private FinalMessage finalMessage;
    private List<FinalMessage> finalMessages;
    private Resuser resuser;
    private List<FinalComment> finalComments;
    private UserLove userLove;

    @Override
    public void insert(FinalMessage record) {

       String msgId= messageService.insert(record.getMessage());
        if(msgId=="")
            return ;
        MessageContent messageContent=record.getMessageContent();
        if (messageContent.getDetail()!= "") {
            messageContent.setMsgId(msgId);
            if (messageContentService.insert(messageContent) == 0) {
                messageService.deleteMsgId(msgId);
                return;
            }

        }
        List<Messagelabel> labellist=record.getLabellist();
        Messagelabel label;
        for (int i=0;i<labellist.size();i++){
            label=labellist.get(i);
            label.setMsgId(msgId);
            label.setSchoolCode(record.getMessage().getSchoolCode());
            messagelabelService.insert(label);

        }

        List<Messagefile> filelist=record.getFilelist();
        if (filelist==null)
            return;
        Messagefile file;
        for (int i=0;i<filelist.size();i++){
            file=filelist.get(i);
            file.setMsgId(msgId);
            messagefileService.insert(file);
        }
        userRankService.addMessage(record.getMessage().getUidSend());


    }

    @Override
    public void forward(FinalMessage forward) {
        String msgId= messageService.insert(forward.getMessage());
        if(msgId=="")
            return ;
        MessageContent messageContent=forward.getMessageContent();
        if (messageContent.getDetail()!= "") {
            messageContent.setMsgId(msgId);
            if (messageContentService.insert(messageContent) == 0) {
                messageService.deleteMsgId(msgId);
                return;
            }

        }
        userRankService.addMessage(forward.getMessage().getUidSend());
        unreadService.addForward(forward.getMessage().getUidCreate());


    }


    @Override
    public void update(FinalMessage record) {

    }

    @Override
    public void delete(String msgId) {

    }

    @Override
    public List<FinalMessage> selectpage(String schoolCode, int page,int size,String label,String uid) {
        List<Message> messages;
        if(label.equals("全部")==false&&label.equals("推荐")==false) {
            List<Messagelabel> messagelabels = messagelabelService.getMsgId(schoolCode, page, size, label);
            System.out.println(messagelabels);
            messages=new ArrayList<Message>();
            Message msg;
            int i=0;
            if(messagelabels==null)
                return null;
            for (;i<messagelabels.size();i++){
                msg=new Message();
                msg=messageService.selectMsgId(messagelabels.get(i).getMsgId());
                messages.add(msg);
            }
        }
         else  messages= messageService.queryUserByPage(schoolCode, page,size);
         if(messages==null)
             return null;
        finalMessages=new ArrayList<FinalMessage>() ;
        finalMessage=new FinalMessage();
        resuser=new Resuser();
        messagelabels=new ArrayList<Messagelabel>();
        messagefiles=new  ArrayList<Messagefile>();
        int i=0;
        for(;i<messages.size();i++){
            messageContent=messageContentService.getMessagecontentone(messages.get(i).getMsgId());
            messagelabels=messagelabelService.getList(messages.get(i).getMsgId());
            messagefiles=messagefileService.getFile(messages.get(i).getMsgId());
            resuser=resuserservice.selectOne(messages.get(i).getUidSend(),"uid");
            finalComments=finalCommentService.selectMsgId(messages.get(i).getMsgId(),1,uid);
            finalMessage.setMessage(messages.get(i));
            finalMessage.setMessageContent(messageContent);
            finalMessage.setLabellist(messagelabels);
            finalMessage.setFilelist(messagefiles);
            finalMessage.setResuser(resuser);
            finalMessage.setFinalComments(finalComments);
            if(userLoveService.selectone(messages.get(i).getMsgId(),uid,"message")!=null)
                finalMessage.setIslove(true);
            else finalMessage.setIslove(false);
            if(messages.get(i).getUidSend()!=messages.get(i).getUidCreate())
                finalMessage.setName(userService.selectName(messages.get(i).getUidCreate()));
            finalMessages.add(finalMessage);
            finalMessage=new FinalMessage();
            messageService.addnumberBrowse(messages.get(i).getMsgId());


        }

        return finalMessages;
    }


}

