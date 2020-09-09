package com.wcxy.platform.service;


import com.wcxy.platform.entity.UserLove;

/**
 * (MessageloveList)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:10
 */
public interface UserLoveService {
   int insert(UserLove record);

    void update(UserLove record);

    int delete(UserLove record);

    UserLove selectone(String msgId,String uid,String type);
}