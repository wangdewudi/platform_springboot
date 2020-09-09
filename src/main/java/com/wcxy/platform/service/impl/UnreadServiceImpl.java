package com.wcxy.platform.service.impl;

import com.wcxy.platform.Mapper.UnreadMapper;
import com.wcxy.platform.entity.Campus;
import com.wcxy.platform.entity.Unread;
import com.wcxy.platform.service.UnreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Unread)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 14:31:12
 */
@Service
public class UnreadServiceImpl implements UnreadService {

    @Autowired
    private UnreadMapper mapper;


    @Override
    public void insert(String uid) {
        Unread unread=new Unread();
        unread.setUid(uid);
        unread.setTime(new Date());
        mapper.insertSelective(unread);
    }

    @Override
    public void update(Unread record) {


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
    public void deleteallLove(String uid) {
        mapper.deletealllove(uid);
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
    public void deleteallComment(String uid) {
        mapper.deleteallcomment(uid);
    }

    @Override
    public void addForward(String uid) {
        mapper.addforward(uid);
    }

    @Override
    public void deleteForward(String uid) {
        mapper.deleteforward(uid);
    }

    @Override
    public void deleteallForward(String uid) {
        mapper.deleteallforward(uid);
    }

    @Override
    public void addFollow(String uid) {
        mapper.addfollow(uid);
    }

    @Override
    public void deleteFollow(String uid) {
        mapper.deletefollow(uid);
    }

    @Override
    public void deleteallFollow(String uid) {
        mapper.deleteallfollow(uid);
    }

    @Override
    public void addFans(String uid) {
        mapper.addfans(uid);
    }

    @Override
    public void deleteFans(String uid) {
        mapper.deletefans(uid);
    }

    @Override
    public void deleteallFans(String uid) {
        mapper.deleteallfans(uid);
    }
}