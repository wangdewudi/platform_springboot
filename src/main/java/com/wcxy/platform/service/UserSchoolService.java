package com.wcxy.platform.service;



import com.wcxy.platform.entity.Userschool;

/**
 * (UserSchool)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:15
 */
public interface UserSchoolService {


    void insert(Userschool record);

    void update(Userschool record);

    void delete(Integer id);

    Userschool selectUid(String uid);
}