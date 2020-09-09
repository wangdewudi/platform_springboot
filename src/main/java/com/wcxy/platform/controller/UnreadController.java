package com.wcxy.platform.controller;

import com.wcxy.platform.service.UnreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Unread)表控制层
 *
 * @author makejava
 * @since 2020-07-17 14:31:12
 */
@RestController
@RequestMapping("unread")
public class UnreadController {
    /**
     * 服务对象
     */
    @Autowired
    private UnreadService unreadService;



}