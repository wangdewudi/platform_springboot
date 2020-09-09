package com.wcxy.platform.controller;

import com.wcxy.platform.entity.Suggestion;
import com.wcxy.platform.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("suggestion")
public class SuggestionController {

    @Autowired
    private SuggestionService service;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> insert(@RequestBody Suggestion suggestion){
        System.out.println("suggestion/inert");
        try {

            service.insert(suggestion);
            return ResponseEntity.status(HttpStatus.CREATED).build();//响应201

        }catch (Exception e){
            System.out.println("用户信息插入错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }

}
