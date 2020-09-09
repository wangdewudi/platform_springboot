package com.wcxy.platform.service;


import com.wcxy.platform.entity.Unread;

/**
 * (Unread)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:12
 */
public interface UnreadService {

    void insert(String uid);

    void update(Unread record);

    void delete(Integer id);

    void addLove(String uid);

    void deleteLove(String uid);

    void deleteallLove(String uid);

    void addComment(String uid);

    void deleteComment(String uid);

    void deleteallComment(String uid);

    void addForward(String uid);

    void deleteForward(String uid);

    void deleteallForward(String uid);

    void addFollow(String uid);

    void deleteFollow(String uid);

    void deleteallFollow(String uid);

    void addFans(String uid);

    void deleteFans(String uid);

    void deleteallFans(String uid);
}