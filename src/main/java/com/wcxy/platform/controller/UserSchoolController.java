package com.wcxy.platform.controller;

import com.wcxy.platform.entity.Comment;
import com.wcxy.platform.entity.Resuser;
import com.wcxy.platform.entity.User;
import com.wcxy.platform.entity.Userschool;
import com.wcxy.platform.service.UserSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserSchool)表控制层
 *
 * @author makejava
 * @since 2020-07-17 14:31:15
 */
@RestController
@RequestMapping("userschool")
public class UserSchoolController {
    /**
     * 服务对象
     */
    @Resource
    private UserSchoolService service;

    @RequestMapping(value = "{uid}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> selectUid(@PathVariable("uid") String uid){
        System.out.println("Banword/selectAll");
        try {




               Userschool result=service.selectUid(uid);


            System.out.println(result);
            if (result==null){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();//响应404
            }

            return ResponseEntity.ok(result);//响应201

        }catch (Exception e){
            System.out.println("用户信息查询错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }
    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> insert(@RequestBody Userschool userschool){
        System.out.println("FinalMessage/inert");
        try {
            service.insert(userschool);
            return ResponseEntity.status(HttpStatus.CREATED).build();//响应201

        }catch (Exception e){
            System.out.println("用户信息插入错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }
}