package com.wcxy.platform.controller;



import com.wcxy.platform.entity.Resuser;
import com.wcxy.platform.entity.User;
import com.wcxy.platform.service.ResuserService;
import com.wcxy.platform.tools.WeChat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("getopenid")
public class GetopenidController {

    @RequestMapping(value = "{code}&{state}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> Getopenid(@PathVariable("code") String code,@PathVariable("state") String state){
        WeChat weChat=new WeChat();

        try {
            String openid="";
            String appid = "wxa8c85f81df06fb01";
            String secret = "9ac63ba5d90b114c63259d826673282c";
            if(state.equals("wx")){
                openid=weChat.GetwxOpenID(appid,secret,code);
            }
            else if(state.equals("qq")){
                appid = "1110819071";
                secret = "tH1yv94F6jkQhQUq";
                openid=weChat.GetwxOpenID(appid,secret,code);
            }

//            Map<String, Object> result = new HashMap<String, Object>();
//            result.put("id",openid);

            return ResponseEntity.ok(openid);//响应201

        }catch (Exception e){
            System.out.println("用户信息查询错误");
            e.printStackTrace();
        }
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//响应500
    }
}
