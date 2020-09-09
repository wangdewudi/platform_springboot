package com.wcxy.platform.service;

import com.wcxy.platform.entity.Help;

import java.util.List;

public interface HelpService {

    int insert(Help help);


    Help selectone (Integer id);

    List<Help> selectpage(Integer page);
}
