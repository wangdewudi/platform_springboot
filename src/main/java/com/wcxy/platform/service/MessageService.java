package com.wcxy.platform.service;


import com.wcxy.platform.entity.Message;

import java.util.List;

/**
 * (Message)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:08
 */
public interface MessageService {

    String insert(Message record);

    void update(Message record);

    void addnumberBrowse(String msgId);

    void addnumberLove(String msgId,String uid);

    void deletenumberLove(String msgId,String uid);

    void addnumberComment(String msgId);

    void deletenumberComment(String msgId);

    void delete(Integer id);

    void deleteMsgId(String msgId);

    Message selectMsgId(String msgId);

    List<Message> queryUserByPage(String schoolCode,int page, int size);
}