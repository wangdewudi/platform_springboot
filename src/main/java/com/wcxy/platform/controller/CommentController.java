package com.wcxy.platform.controller;

import com.wcxy.platform.entity.Comment;
import com.wcxy.platform.entity.FinalMessage;
import com.wcxy.platform.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Comment)表控制层
 *
 * @author makejava
 * @since 2020-07-17 14:31:06
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    /**
     * 服务对象
     */

    @Autowired
    private CommentService service;
    /**
     * 通过主键查询单条数据
     *
     * @param  主键
     * @return 单条数据
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> insert(@RequestBody Comment comment){
        System.out.println("FinalMessage/inert");
        try {
            service.insert(comment);
            return ResponseEntity.status(HttpStatus.CREATED).build();//响应201

        }catch (Exception e){
            System.out.println("用户信息插入错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }

    @RequestMapping(value ="{commentId}&{type}&{uid}",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Void> addlove( @PathVariable("commentId") String commentId,@PathVariable("type") String type,@PathVariable("uid") String uid){
        System.out.println("FinalMessage/inert");
        try {
            if(type.equals("addlove"))
            service.addLove(commentId,uid);
            else  if(type.equals("deletelove"))
                service.deleteLove(commentId,uid);
            return ResponseEntity.status(HttpStatus.CREATED).build();//响应201

        }catch (Exception e){
            System.out.println("用户信息插入错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }

}