package com.wcxy.platform.service;

import com.wcxy.platform.entity.Messagelabel;

import java.util.List;

public interface MessagelabelService {

    void insert(Messagelabel record);

    void update(Messagelabel record);

    void delete(Integer id);

    List<Messagelabel> getList(String msgId);

    List<Messagelabel> getMsgId(String SchoolCode,int page,int size,String label);
}
