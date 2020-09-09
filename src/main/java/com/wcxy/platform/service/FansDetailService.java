package com.wcxy.platform.service;

import com.wcxy.platform.entity.FansDetail;

/**
 * (FansDetail)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:06
 */
public interface FansDetailService {

    void insert(FansDetail record);

    void update(FansDetail record);

    void delete(Integer id);
}