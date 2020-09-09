package com.wcxy.platform.Mapper;

import com.wcxy.platform.entity.TimeRegister;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (TimeRegister)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-17 14:31:11
 */
@Repository
public interface TimeRegisterMapper extends Mapper<TimeRegister> {


}