package com.wcxy.platform.controller;



import com.wcxy.platform.entity.Help;
import com.wcxy.platform.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("help")
public class HelpController {

    @Autowired
    private HelpService service;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> insert(@RequestBody Help help) {
        System.out.println("help/inert");
        try {

            service.insert(help);
            return ResponseEntity.status(HttpStatus.CREATED).build();//响应201

        } catch (Exception e) {
            System.out.println("用户信息插入错误");
            e.printStackTrace();
        }


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }

    @RequestMapping(value = "{page}&{type}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> select(@PathVariable("page") Integer page,@PathVariable("type") String type) {
        System.out.println("help/inert");
        try {
            if(type.equals("all")) {
                List<Help> helps=service.selectpage(page);
                return ResponseEntity.ok(helps);//响应201
            }
            else {
                Help helps = service.selectone(page);
                return ResponseEntity.ok(helps);//响应201
            }



        } catch (Exception e) {
            System.out.println("用户信息插入错误");
            e.printStackTrace();
        }


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }

}