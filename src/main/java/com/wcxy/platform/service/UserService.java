package com.wcxy.platform.service;


import com.wcxy.platform.entity.Resuser;
import com.wcxy.platform.entity.User;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:13
 */
public interface UserService {

    void insert(User record);

    void update(User record);

    void delete(Integer id);

    User selectOpenid(String openid);

    User selectUid(String uid);

    User selectQQopenid(String qq);

    String selectName(String uid);

}