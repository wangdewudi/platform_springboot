package com.wcxy.platform.service.impl;


import com.wcxy.platform.Mapper.UserMapper;
import com.wcxy.platform.entity.*;
import com.wcxy.platform.service.UserService;
import com.wcxy.platform.tools.myrandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 14:31:13oyQbd4vbdcLjDaorFr5m9hVhnkWA1
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private TimeRegisterServiceImpl timeRegisterService;

    @Autowired
    private UnreadServiceImpl unreadService;

    @Autowired
    private UserRankServiceImpl userRankService;


    @Override
    public void insert(User record) {
        myrandom random=new myrandom();
        String str= "W"+random.getRandomString(10);
        while(selectUid(str)!=null)
            str= "W"+random.getRandomString(10);
        record.setUid(str) ;
        if(mapper.insertSelective(record)!=0) {
            timeRegisterService.insert(str);
            unreadService.insert(str);
            userRankService.insert(str);
        }
    }

    @Override
    public void update(User record) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public User selectOpenid(String openid) {
        User record=new User();
        record.setOpenid(openid);
        return mapper.selectOne(record);
    }

    @Override
    public User selectUid(String uid) {
        User record=new User();
        record.setUid(uid);
        return mapper.selectOne(record);
    }

    @Override
    public User selectQQopenid(String qqopenid) {
        User record=new User();
        record.setQqopenid(qqopenid);
        return mapper.selectOne(record);
    }

    @Override
    public String selectName(String uid) {
        User user=new User();
        user.setUid(uid);

        return  mapper.selectOne(user).getNickname();
    }


}
