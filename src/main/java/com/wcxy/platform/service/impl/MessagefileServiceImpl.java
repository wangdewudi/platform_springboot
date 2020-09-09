package com.wcxy.platform.service.impl;


import com.wcxy.platform.Mapper.MessagefileMapper;
import com.wcxy.platform.entity.Messagefile;
import com.wcxy.platform.service.MessagefileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagefileServiceImpl implements MessagefileService {

    @Autowired
    private MessagefileMapper mapper;
    private Messagefile messagefile;

    @Override
    public void insert(Messagefile record) {

        mapper.insert(record);
    }

    @Override
    public void update(Messagefile record) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Messagefile> getFile( String msgId) {
        messagefile=new Messagefile();
        messagefile.setMsgId(msgId);
        return mapper.select(messagefile);
    }
}
