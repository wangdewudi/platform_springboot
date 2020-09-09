package com.wcxy.platform.Mapper;


import com.wcxy.platform.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-17 14:31:13
 */
@Repository
public interface UserMapper extends Mapper<User> {


}