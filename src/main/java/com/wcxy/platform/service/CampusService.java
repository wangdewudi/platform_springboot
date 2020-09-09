package com.wcxy.platform.service;

import com.wcxy.platform.entity.Campus;

import java.util.List;

/**
 * (Campus)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:05
 */
public interface CampusService {

   void insert(Campus record);

   void update(Campus record);

   void delete(Integer id);

   Campus selectCode(String schoolCode,String campusCode);

   List<Campus> selectall(String schoolCode);

}