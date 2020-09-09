package com.wcxy.platform.controller;

import com.wcxy.platform.entity.Campus;
import com.wcxy.platform.entity.School;
import com.wcxy.platform.service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Campus)表控制层
 *
 * @author makejava
 * @since 2020-07-17 14:31:05
 */
@RestController
@RequestMapping("campus")
public class CampusController {
    /**
     * 服务对象
     */
    @Autowired
    private CampusService service;


    @RequestMapping(value = "{schoolCode}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> selectUid(@PathVariable("schoolCode") String schoolCode){

        try {

            List<Campus> campuses=new ArrayList<Campus>();
            campuses=service.selectall(schoolCode);

            return ResponseEntity.ok(campuses);//响应201

        }catch (Exception e){
            System.out.println("用户信息查询错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }




}