package com.wcxy.platform.controller;

import com.wcxy.platform.entity.MessageContent;
import com.wcxy.platform.service.MessageContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (MessageContent)表控制层
 *
 * @author makejava
 * @since 2020-07-17 14:31:09
 */
@RestController
@RequestMapping("messageContent")
public class MessageContentController {
    /**
     * 服务对象
     */
    @Autowired
    private MessageContentService messageContentService;



}