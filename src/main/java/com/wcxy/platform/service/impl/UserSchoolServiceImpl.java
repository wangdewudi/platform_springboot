package com.wcxy.platform.service.impl;

import com.wcxy.platform.Mapper.UserSchoolMapper;
import com.wcxy.platform.entity.Userschool;
import com.wcxy.platform.service.UserSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (UserSchool)表服务实现类
 *
 * @author makejavaS
 * @since 2020-07-17 14:31:15
 */
@Service("UserSchoolService")
public class UserSchoolServiceImpl implements UserSchoolService {

    @Autowired
    private UserSchoolMapper mapper;


    @Override
    public void insert(Userschool record) {
        mapper.insertSelective(record);
    }

    @Override
    public void update(Userschool record) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Userschool selectUid(String uid) {
        System.out.println("sdsad");
        Userschool record=new Userschool();
        record.setUid(uid);

        record= mapper.selectOne(record);


       return record;

    }
}