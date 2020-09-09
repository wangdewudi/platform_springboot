package com.wcxy.platform.service;


import com.wcxy.platform.entity.Messagefile;

import java.util.List;

public interface MessagefileService {

    void insert(Messagefile record);

    void update(Messagefile record);

    void delete(Integer id);

    List<Messagefile> getFile(String msgId);
}
