package com.wcxy.platform.controller;

import com.wcxy.platform.entity.UserRank;
import com.wcxy.platform.service.UserRankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (UserRank)表控制层
 *
 * @author makejava
 * @since 2020-07-17 14:31:14
 */
@RestController
@RequestMapping("userRank")
public class UserRankController {
    /**
     * 服务对象
     */
    @Resource
    private UserRankService userRankService;


}