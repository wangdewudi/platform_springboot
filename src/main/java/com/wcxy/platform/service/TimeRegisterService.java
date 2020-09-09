package com.wcxy.platform.service;


import com.wcxy.platform.entity.TimeRegister;

/**
 * (TimeRegister)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:11
 */
public interface TimeRegisterService {
    void insert(String uid);

    void update(TimeRegister record);

    void delete(Integer id);
}