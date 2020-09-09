package com.wcxy.platform.controller;

import com.wcxy.platform.entity.Comment;
import com.wcxy.platform.entity.FinalMessage;
import com.wcxy.platform.entity.School;
import com.wcxy.platform.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (School)表控制层
 *
 * @author makejava
 * @since 2020-07-17 14:31:11
 */
@RestController
@RequestMapping("school")
public class SchoolController {
    /**
     * 服务对象
     */
    @Autowired
    private SchoolService service;

    @RequestMapping(value = "{key}&{page}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> selectUid(@PathVariable("key") String key, @PathVariable("page") String page){

        try {

            List<School> schools=new ArrayList<School>();
            schools=service.selectkeypage(Integer.parseInt(page),key);

            return ResponseEntity.ok(schools);//响应201

        }catch (Exception e){
            System.out.println("用户信息查询错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }


}