package com.wcxy.platform.service.impl;

import com.wcxy.platform.Mapper.MessageContentMapper;
import com.wcxy.platform.entity.Campus;
import com.wcxy.platform.entity.MessageContent;
import com.wcxy.platform.service.MessageContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MessageContent)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 14:31:09
 */
@Service
public class MessageContentServiceImpl implements MessageContentService {
    @Autowired
    private MessageContentMapper mapper;
    private MessageContent messageContent;

    @Override
    public int insert(MessageContent record) {
      return   mapper.insertSelective(record);
    }

    @Override
    public void update(MessageContent record) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public MessageContent getMessagecontentone( String msgId) {
        messageContent=new MessageContent();
        messageContent.setMsgId(msgId);
        return mapper.selectOne(messageContent);
    }
}