package com.wcxy.platform.Mapper;

import com.wcxy.platform.entity.School;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * (School)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-17 14:31:10
 */
@Repository
public interface SchoolMapper extends Mapper<School> {

}