package com.wcxy.platform.controller;

import com.wcxy.platform.entity.FinalComment;
import com.wcxy.platform.entity.FinalMessage;
import com.wcxy.platform.service.CommentService;
import com.wcxy.platform.service.FinalCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("finalcomment")
public class FinalCommentController {

   @Autowired
    private FinalCommentService service;
    @RequestMapping(value = "{msgId}&{page}&{type}&{uid}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> selectUid(@PathVariable("msgId") String msgId, @PathVariable("page") String page, @PathVariable("type") String type, @PathVariable("uid") String uid){

        try {

            List<FinalComment> finalComments=new ArrayList<FinalComment>();
            if(type.equals("msgId"))
            finalComments=service.SelectComment(msgId,Integer.parseInt(page),uid);
            else   finalComments=service.SelecttwoComment(msgId,Integer.parseInt(page),uid);

            return ResponseEntity.ok(finalComments);//响应201

        }catch (Exception e){
            System.out.println("用户信息查询错误");
            e.printStackTrace();
        }


        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }

}
