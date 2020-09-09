package com.wcxy.platform.service.impl;

import com.wcxy.platform.Mapper.CampusMapper;
import com.wcxy.platform.Mapper.SchoolMapper;
import com.wcxy.platform.Mapper.UserSchoolMapper;
import com.wcxy.platform.entity.*;
import com.wcxy.platform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResuserServiceImpl implements ResuserService {

    @Autowired
    UserService userService;
    @Autowired
    SchoolService schoolServiceimpl;
    @Autowired
    CampusService campusServiceimpl;
    @Autowired
    UserSchoolService userSchoolServiceimpl;

    @Override
    public Resuser selectOne(String openid,String type) {

        Resuser res=new Resuser();
        User user=null;
        if(type.equals("openid"))
            user=userService.selectOpenid(openid);
        else if(type.equals("uid"))
            user=userService.selectUid(openid);
        else if(type.equals("qq"))
            user=userService.selectQQopenid(openid);
        else return null;
        res.setUser(user);
    if (user==null)
        return null;
        Userschool userschool=userSchoolServiceimpl.selectUid(user.getUid());
        res.setUserschool(userschool);
        if(userschool!=null){
            School school= schoolServiceimpl.selectCode(userschool.getSchoolCode());
            res.setSchool(school);
            if(userschool.getCampusCode()!="0"){
                Campus campus=campusServiceimpl.selectCode(userschool.getSchoolCode(),userschool.getCampusCode());
                res.setCampus(campus);
            }
        }



        return res;

    }


}
