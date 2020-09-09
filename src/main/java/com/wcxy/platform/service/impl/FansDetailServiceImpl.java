package com.wcxy.platform.service.impl;


import com.wcxy.platform.Mapper.FansDetailMapper;
import com.wcxy.platform.entity.Campus;
import com.wcxy.platform.entity.FansDetail;
import com.wcxy.platform.service.FansDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (FansDetail)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 14:31:06
 */
@Service
public class FansDetailServiceImpl implements FansDetailService {

    @Autowired
    private FansDetailMapper mapper;


    @Override
    public void insert(FansDetail record) {
        mapper.insertSelective(record);
    }

    @Override
    public void update(FansDetail record) {

    }

    @Override
    public void delete(Integer id) {

    }
}