package com.wcxy.platform.controller;

import com.wcxy.platform.entity.Message;
import com.wcxy.platform.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * (Forward)表控制层
 *
 * @author makejava
 * @since 2020-07-17 14:31:07
 */
@RestController
@RequestMapping("forward")
public class CollectionController {
    /**
     * 服务对象
     */
    @Autowired
    private CollectionService service;

    @RequestMapping(value ="{schoolCode}" ,method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> insert(@RequestBody Message message, @PathVariable("schoolCode") String schoolCode){
        System.out.println("FinalMessage/inert"+schoolCode);
        try {

            service.forward(message,schoolCode);
            return ResponseEntity.status(HttpStatus.CREATED).build();//响应201

        }catch (Exception e){
            System.out.println("用户信息插入错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }

}