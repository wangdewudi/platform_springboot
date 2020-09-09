package com.wcxy.platform.service;


import com.wcxy.platform.entity.UserRank;

/**
 * (UserRank)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:14
 */
public interface UserRankService {

    void insert(String uid);

    void update(UserRank record);

    void delete(Integer id);

    void addLove(String uid);

    void deleteLove(String uid);

    void addComment(String uid);

    void deleteComment(String uid);

    void addMessage(String uid);

    void deleteMessage(String uid);

}