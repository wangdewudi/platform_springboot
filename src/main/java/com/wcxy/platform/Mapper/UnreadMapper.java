package com.wcxy.platform.Mapper;

import com.wcxy.platform.entity.Unread;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * (Unread)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-17 14:31:12
 */
@Repository
public interface UnreadMapper extends Mapper<Unread> {

    @Update("update  unread set unreadLove=unreadLove+1 where uid=#{uid};")
    int addlove(@Param("uid") String uid);

    @Update("update  unread set unreadLove=unreadLove-1 where uid=#{uid};")
    int deletelove(@Param("uid") String uid);

    @Update("update  unread set unreadLove=0 where uid=#{uid};")
    int deletealllove(@Param("uid") String uid);

    @Update("update  unread set unreadComment=unreadComment+1 where uid=#{uid};")
    int addcomment(@Param("uid") String uid);

    @Update("update  unread set unreadComment=0 where uid=#{uid};")
    int deleteallcomment(@Param("uid") String uid);

    @Update("update  unread set unreadComment=unreadComment-1 where uid=#{uid};")
    int deletecomment(@Param("uid") String uid);

    @Update("update  unread set unreadForward=unreadForward+1 where uid=#{uid};")
    int addforward(@Param("uid") String uid);

    @Update("update  unread set unreadForward=unreadForward-1 where uid=#{uid};")
    int deleteforward(@Param("uid") String uid);

    @Update("update  unread set unreadForward=0 where uid=#{uid};")
    int deleteallforward(@Param("uid") String uid);

    @Update("update  unread set unreadFollow=unreadFollow+1 where uid=#{uid};")
    int addfollow(@Param("uid") String uid);

    @Update("update  unread set unreadFollow=0 where uid=#{uid};")
    int deleteallfollow(@Param("uid") String uid);

    @Update("update  unread set unreadFollow=unreadFollow-1 where uid=#{uid};")
    int deletefollow(@Param("uid") String uid);

    @Update("update  unread set unreadFans=unreadFans+1 where uid=#{uid};")
    int addfans(@Param("uid") String uid);

    @Update("update  unread set unreadFans=0 where uid=#{uid};")
    int deleteallfans(@Param("uid") String uid);

    @Update("update  unread set unreadFans=unreadFans-1 where uid=#{uid};")
    int deletefans(@Param("uid") String uid);




}