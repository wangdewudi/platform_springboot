package com.wcxy.platform.Mapper;

import com.wcxy.platform.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


/**
 * (Comment)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-17 14:31:05
 */
@Repository
public interface CommentMapper extends Mapper<Comment> {

    @Update("update comment set numberComment=numberComment+1 where commentId=#{commentId};")
    int addcomment(@Param("commentId") String commentId);

    @Update("update comment set numberComment=numberComment-1 where commentId=#{commentId};")
    int deletecomment(@Param("commentId") String commentId);

    @Update("update comment set numberLove=numberLove+1 where commentId=#{commentId};")
    int addlove(@Param("commentId") String commentId);

    @Update("update comment set numberLove=numberLove-1 where commentId=#{commentId};")
    int deletelove(@Param("commentId") String commentId);
}