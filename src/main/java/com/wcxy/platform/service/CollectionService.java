package com.wcxy.platform.service;


import com.wcxy.platform.entity.Collection;
import com.wcxy.platform.entity.Message;

/**
 * (Forward)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:07
 */
public interface CollectionService {

    void insert(Collection record);

    void forward(Message message, String uid);

    void update(Collection record);

    void delete(Integer id);
}