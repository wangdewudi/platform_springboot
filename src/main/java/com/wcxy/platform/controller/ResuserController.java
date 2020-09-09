package com.wcxy.platform.controller;

import com.wcxy.platform.entity.Resuser;
import com.wcxy.platform.entity.User;
import com.wcxy.platform.service.ResuserService;
import com.wcxy.platform.tools.WeChat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("resuser")
public class ResuserController {
    @Resource
    private ResuserService service;

    @RequestMapping(value = "{openid}&{state}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> selectUid(@PathVariable("openid") String openid,@PathVariable("state") String state){

        try {
            Resuser result;

            result=service.selectOne(openid,state);
           
           

            return ResponseEntity.ok(result);//响应201

        }catch (Exception e){
            System.out.println("用户信息查询错误");
            e.printStackTrace();
        }
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }

}
