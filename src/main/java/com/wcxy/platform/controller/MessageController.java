package com.wcxy.platform.controller;

import com.wcxy.platform.entity.Message;
import com.wcxy.platform.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * (Message)表控制层
 *
 * @author makejava
 * @since 2020-07-17 14:31:08
 */
@RestController
@RequestMapping("message")
public class MessageController {
    /**
     * 服务对象
     */
    @Resource
    private MessageService service;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value ="{msgId}&{type}&{uid}",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> addlove(@PathVariable("msgId") String msgId, @PathVariable("type") String type, @PathVariable("uid") String uid){
        System.out.println("FinalMessage/inert");
        try {
            System.out.println(type);
            if(type.equals("addlove"))
                service.addnumberLove(msgId,uid);
            else  if(type.equals("deletelove"))
                service.deletenumberLove(msgId,uid);
            return ResponseEntity.status(HttpStatus.CREATED).build();//响应201

        }catch (Exception e){
            System.out.println("用户信息插入错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }


}