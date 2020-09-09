package com.wcxy.platform.service.impl;

import com.wcxy.platform.Mapper.UserRankMapper;
import com.wcxy.platform.entity.Campus;
import com.wcxy.platform.entity.UserRank;
import com.wcxy.platform.service.UserRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserRank)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 14:31:14
 */
@Service
public class UserRankServiceImpl implements UserRankService {

    @Autowired
    private UserRankMapper mapper;


    @Override
    public void insert(String uid) {
        UserRank userRank=new UserRank();
        userRank.setUid(uid);

        mapper.insertSelective(userRank);
    }

    @Override
    public void update(UserRank record) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void addLove(String uid) {
        mapper.addlove(uid);
    }

    @Override
    public void deleteLove(String uid) {
        mapper.deletelove(uid);
    }

    @Override
    public void addComment(String uid) {
        mapper.addcomment(uid);
    }

    @Override
    public void deleteComment(String uid) {
        mapper.deletecomment(uid);
    }

    @Override
    public void addMessage(String uid) {
        mapper.addmessage(uid);
    }

    @Override
    public void deleteMessage(String uid) {
        mapper.deletemessage(uid);
    }
}