package com.wcxy.platform.service.impl;

import com.wcxy.platform.Mapper.UserLoveMapper;
import com.wcxy.platform.entity.UserLove;
import com.wcxy.platform.service.UserLoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (MessageloveList)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 14:31:10
 */
@Service
public class UserLoveServiceImpl implements UserLoveService {

    @Autowired
    private UserLoveMapper mapper;

    private UserLove userLove;

    @Override
    public int insert(UserLove record) {
         return mapper.insertSelective(record);
    }

    @Override
    public void update(UserLove record) {

    }

    @Override
    public int delete(UserLove record) {
           return mapper.delete(record);
    }

    @Override
    public UserLove selectone(String msgId, String uid, String type) {
        userLove=new UserLove();
        userLove.setType(type);
        userLove.setAdmirerUid(uid);
        userLove.setMsgId(msgId);

        return mapper.selectOne(userLove);
    }
}