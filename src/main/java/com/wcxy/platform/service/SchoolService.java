package com.wcxy.platform.service;


import com.wcxy.platform.entity.School;

import java.util.List;

/**
 * (School)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:10
 */
public interface SchoolService {

    void insert(School record);

    void update(School record);

    void delete(Integer id);

    School selectCode(String schoolCode);

    List<School> selectkeypage(Integer page, String key);

}