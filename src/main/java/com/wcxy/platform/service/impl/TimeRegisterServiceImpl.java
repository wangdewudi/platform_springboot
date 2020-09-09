package com.wcxy.platform.service.impl;

import com.wcxy.platform.Mapper.TimeRegisterMapper;
import com.wcxy.platform.entity.Campus;
import com.wcxy.platform.entity.TimeRegister;
import com.wcxy.platform.service.TimeRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (TimeRegister)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 14:31:11
 */
@Service
public class TimeRegisterServiceImpl implements TimeRegisterService {

    @Autowired
    private TimeRegisterMapper mapper;


    @Override
    public void insert(String uid) {
        TimeRegister timeRegister=new TimeRegister();
        timeRegister.setUid(uid);
        timeRegister.setTime(new Date());
        mapper.insertSelective(timeRegister);
    }

    @Override
    public void update(TimeRegister record) {

    }

    @Override
    public void delete(Integer id) {

    }
}