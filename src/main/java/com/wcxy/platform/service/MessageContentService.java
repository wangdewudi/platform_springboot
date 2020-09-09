package com.wcxy.platform.service;


import com.wcxy.platform.entity.MessageContent;

/**
 * (MessageContent)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:09
 */
public interface MessageContentService {

    int insert(MessageContent record);

    void update(MessageContent record);

    void delete(Integer id);

    MessageContent getMessagecontentone(String msgId);
}