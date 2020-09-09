package com.wcxy.platform.controller;

import com.wcxy.platform.entity.FinalMessage;
import com.wcxy.platform.entity.User;
import com.wcxy.platform.service.FinalMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("finalmessage")
public class FinalMessageController {

    @Autowired
    private FinalMessageService service;

    @RequestMapping(value = "{type}",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> insert(@RequestBody FinalMessage message,@PathVariable("type") String type){
        System.out.println("FinalMessage/inert");
        try {
            if(type.equals("create"))
            service.insert(message);
            else if(type.equals("forward"))
                service.forward(message);
            return ResponseEntity.status(HttpStatus.CREATED).build();//响应201

        }catch (Exception e){
            System.out.println("用户信息插入错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }


    @RequestMapping(value = "{schoolCode}&{label}&{page}&{size}&{uid}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> selectUid(@PathVariable("schoolCode") String schoolCode,@PathVariable("label") String label,@PathVariable("page") String page,@PathVariable("size") String size,@PathVariable("uid") String uid){

        try {

            List<FinalMessage> message=new ArrayList<FinalMessage>();
            message=service.selectpage(schoolCode,Integer.parseInt(page),Integer.parseInt(size),label,uid);

            return ResponseEntity.ok(message);//响应201

        }catch (Exception e){
            System.out.println("用户信息查询错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }

}
