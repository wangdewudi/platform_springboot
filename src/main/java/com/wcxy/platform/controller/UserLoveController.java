package com.wcxy.platform.controller;

import com.wcxy.platform.service.UserLoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (MessageloveList)表控制层
 *
 * @author makejava
 * @since 2020-07-17 14:31:10
 */
@RestController
@RequestMapping("messageloveList")
public class UserLoveController {
    /**
     * 服务对象
     */
    @Autowired
    private UserLoveService messageloveListService;


}