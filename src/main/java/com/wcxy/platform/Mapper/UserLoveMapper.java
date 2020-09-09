package com.wcxy.platform.Mapper;
import com.wcxy.platform.entity.UserLove;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


/**
 * (MessageloveList)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-17 14:31:09
 */
@Repository
public interface UserLoveMapper extends Mapper<UserLove> {


}