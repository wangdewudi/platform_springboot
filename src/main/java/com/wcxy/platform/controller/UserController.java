package com.wcxy.platform.controller;

import com.wcxy.platform.entity.User;
import com.wcxy.platform.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-07-17 14:31:13
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */

    @Resource
    private UserService service;


    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> insert(@RequestBody User user){
        System.out.println("User/inert");
        try {
            service.insert(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();//响应201

        }catch (Exception e){
            System.out.println("用户信息插入错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }

    @RequestMapping(value = "{uid}&{state}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> selectUid(@PathVariable("uid") String uid,@PathVariable("state") String state){

        try {
            User user=new User();
            if(state.equals("openid"))
                user =service.selectOpenid(uid);
            else if(state.equals("uid"))
                user=service.selectUid(uid);
            else if(state.equals("qq"))
                user =service.selectQQopenid(uid);

//            if (user==null){
//                return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();//响应404
//            }

            return ResponseEntity.ok(user);//响应201

        }catch (Exception e){
            System.out.println("用户信息查询错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        System.out.println("User/del");
        try {
            if(id==0)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            service.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();//响应204

        } catch (Exception e) {
            System.out.println("用户信息删除错误");
            e.printStackTrace();
        }


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500


    }
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> update(@RequestBody User record){
        System.out.println("User/update");
        System.out.println(record+"ss");
        try {
            service.update(record);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();//响应204

        }catch (Exception e){
            System.out.println("用户信息修改错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }

}