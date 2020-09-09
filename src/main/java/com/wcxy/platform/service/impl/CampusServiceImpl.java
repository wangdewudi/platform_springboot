package com.wcxy.platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcxy.platform.Mapper.CampusMapper;
import com.wcxy.platform.entity.Campus;
import com.wcxy.platform.entity.School;
import com.wcxy.platform.service.CampusService;
import com.wcxy.platform.tools.Getpage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * (Campus)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 14:31:05
 */
@Service("CampusService")
public class CampusServiceImpl implements CampusService {

    @Autowired
    private CampusMapper mapper;

    @Override
    public void insert(Campus record) {
        mapper.insertSelective(record);
    }

    @Override
    public void update(Campus record) {
        mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void delete(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Campus selectCode(String schoolCode, String campusCode) {
        Campus record=new Campus();
        record.setCampusCode(campusCode);
        record.setSchoolCode(schoolCode);
        return mapper.selectOne(record);
    }

    @Override
    public List<Campus> selectall(String schoolCode) {
        Campus campus=new Campus();
        campus.setSchoolCode(schoolCode);


        return mapper.select(campus);


    }
}