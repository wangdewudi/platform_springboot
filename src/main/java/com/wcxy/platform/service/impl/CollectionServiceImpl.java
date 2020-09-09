package com.wcxy.platform.service.impl;

import com.wcxy.platform.Mapper.CollectionMapper;
import com.wcxy.platform.entity.Collection;
import com.wcxy.platform.entity.Message;
import com.wcxy.platform.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * (Forward)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 14:31:07
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper mapper;



    private Collection collection;


    @Override
    public void insert(Collection record) {
        mapper.insertSelective(record);
    }

    @Override
    public void forward(Message record, String uid) {

        collection=new Collection();

        collection.setCollectionuid(uid);


        if(record.getSendmsgId()==null)
            record.setSendmsgId(record.getMsgId());




    }


    @Override
    public void update(Collection record) {

    }

    @Override
    public void delete(Integer id) {

    }
}