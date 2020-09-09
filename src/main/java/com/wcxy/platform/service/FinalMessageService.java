package com.wcxy.platform.service;

import com.wcxy.platform.entity.FinalMessage;
import com.wcxy.platform.entity.Message;

import java.util.List;

public interface FinalMessageService {

    void insert(FinalMessage record);

    void forward(FinalMessage forward);

    void update(FinalMessage record);

    void delete(String msgId);

    List<FinalMessage> selectpage(String schoolCode,int page,int size,String label,String uid);


//    List<FinalMessage> selectlabel(String schoolCode,String label,int page);

}
