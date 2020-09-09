package com.wcxy.platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcxy.platform.Mapper.SchoolMapper;
import com.wcxy.platform.entity.Campus;
import com.wcxy.platform.entity.Message;
import com.wcxy.platform.entity.School;
import com.wcxy.platform.service.SchoolService;
import com.wcxy.platform.tools.Getpage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * (School)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 14:31:10
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper mapper;


    @Override
    public void insert(School record) {
        mapper.insertSelective(record);
    }

    @Override
    public void update(School record) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public School selectCode(String schoolCode) {
        School record=new School();
        record.setSchoolCode(schoolCode);
        return mapper.selectOne(record);
    }

    @Override
    public List<School> selectkeypage(Integer page, String key) {
        Example example = new Example(School.class);
        Example.Criteria criteria=  example.createCriteria();
        if(!key.equals("all"))
        criteria.orLike("school","%" +key+"%" );
        PageHelper.startPage(page, 5,false);
        List<School> schools = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(schools)) {
            return null;
        }
        Getpage getpage=new Getpage();
        //解析分页结果
        schools=getpage.getSchool( new PageInfo<School>(schools));



        return schools;


    }
}