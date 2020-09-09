package com.wcxy.platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcxy.platform.Mapper.MessageMapper;
import com.wcxy.platform.entity.Message;
import com.wcxy.platform.entity.UserLove;
import com.wcxy.platform.service.MessageService;
import com.wcxy.platform.tools.Getpage;
import com.wcxy.platform.tools.myrandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * (Message)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 14:31:08
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper mapper;

    @Autowired
    private UserLoveServiceImpl userLoveService;

    @Autowired
    private UserRankServiceImpl userRankService;

    @Autowired
    private UnreadServiceImpl unreadService;

    private UserLove userLove;




    @Override
    public String insert(Message record) {
        myrandom random=new myrandom();
        String msgId=random.getRandomString(11);
        record.setMsgId(msgId);
        while(selectMsgId(msgId)!=null) {
            msgId =  random.getRandomString(11);
            record.setMsgId(msgId);
        }
        if(mapper.insertSelective(record)==0)
            return "";
        return msgId;

    }

    @Override
    public void update(Message record) {

    }

    @Override
    public void addnumberBrowse(String msgId) {
        mapper.addnumberBrowse(msgId);
    }

    @Override
    public void addnumberLove(String msgId, String uid) {
        userLove=new UserLove();
        userLove.setMsgId(msgId);
        userLove.setAdmirerUid(uid);
        userLove.setType("message");
        userLove.setTime(new Date());
        Message message=this.selectMsgId(msgId);
        userLove.setUid(message.getUidSend());
        if(userLoveService.insert(userLove)!=0) {
            mapper.addnumberLove(msgId);
            userRankService.addLove(message.getUidSend());
            unreadService.addLove(message.getUidSend());

        }
    }

    @Override
    public void deletenumberLove(String msgId, String uid) {

        userLove=new UserLove();
        userLove.setMsgId(msgId);
        userLove.setAdmirerUid(uid);
        userLove.setType("message");
        Message message=this.selectMsgId(msgId);
        userLove.setUid(message.getUidSend());
        if(userLoveService.delete(userLove)!=0) {
            mapper.deletenumberLove(msgId);
            userRankService.deleteLove(message.getUidSend());
            unreadService.deleteLove(message.getUidSend());
        }
    }

    @Override
    public void addnumberComment(String msgId) {

    }

    @Override
    public void deletenumberComment(String msgId) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteMsgId(String msgId) {
        Message message=new Message();
        message.setMsgId(msgId);
        mapper.delete(message);
    }

    @Override
    public Message selectMsgId(String msgId) {
        Message record=new Message();
        record.setMsgId(msgId);

        return mapper.selectOne(record);
    }

    @Override
    public  List<Message>  queryUserByPage(String schoolCode,int page, int size ) {
        //分页


        //过滤
        Example example = new Example(Message.class);
        Example.Criteria criteria=  example.createCriteria();
        criteria.andEqualTo("schoolCode",schoolCode);

//            example.setDistinct(status);
//        }
//        example.setTableName("message_"+schoolCode);

//            if(key!="")
//            example.createCriteria().orLike("label", "%" + key.toLowerCase() + "%");

        //根据相应的字段进行排序

//            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
          example.setOrderByClause("id desc ");
//
        //查询
        PageHelper.startPage(page, size,false);
        List<Message> messages = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(messages)) {
            return null;
        }
        Getpage getpage=new Getpage();
        //解析分页结果
          messages=getpage.getMessage( new PageInfo<Message>(messages));



        return messages;

    }

}