package com.wcxy.platform.Mapper;

import com.wcxy.platform.entity.User;
import com.wcxy.platform.entity.UserRank;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (UserRank)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-17 14:31:14
 */
@Repository
public interface UserRankMapper extends Mapper<UserRank> {

    @Update("update  userrank set numberLove=numberLove+1 where uid=#{uid};")
    int addlove(@Param("uid") String uid);

    @Update("update  userrank set numberLove=numberLove-1 where uid=#{uid};")
    int deletelove(@Param("uid") String uid);

    @Update("update  userrank set numberComment=numberComment+1 where uid=#{uid};")
    int addcomment(@Param("uid") String uid);

    @Update("update userrank set numberComment=numberComment-1 where uid=#{uid};")
    int deletecomment(@Param("uid") String uid);

    @Update("update userrank set numberMessage=numberMessage+1 where uid=#{uid};")
    int addmessage(@Param("uid") String uid);

    @Update("update userrank set numberMessage=numberMessage-1 where uid=#{uid};")
    int deletemessage(@Param("uid") String uid);

    @Update("update userrank set numberCollection=numberCollection+1 where uid=#{uid};")
    int addCollection(@Param("uid") String uid);

    @Update("update userrank set numberCollection=numberCollection-1 where uid=#{uid};")
    int deleteCollection(@Param("uid") String uid);

}