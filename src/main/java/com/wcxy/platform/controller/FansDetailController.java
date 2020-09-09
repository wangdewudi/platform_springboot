package com.wcxy.platform.controller;

import com.wcxy.platform.entity.FansDetail;
import com.wcxy.platform.service.FansDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (FansDetail)表控制层
 *
 * @author makejava
 * @since 2020-07-17 14:31:06
 */
@RestController
@RequestMapping("fansDetail")
public class FansDetailController {
    /**
     * 服务对象
     */
    @Autowired
    private FansDetailService fansDetailService;


}