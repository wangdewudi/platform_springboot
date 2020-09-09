package com.wcxy.platform.Mapper;

import com.wcxy.platform.entity.Message;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


/**
 * (Message)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-17 14:31:08
 */
@Repository
public interface MessageMapper extends Mapper<Message> {

    @Update("update  message set numberBrowse=numberBrowse+1 where msgId=#{msgId};")
    int addnumberBrowse(@Param("msgId") String msgId);

    @Update("update  message set numberLove=numberLove+1 where msgId=#{msgId};")
    int addnumberLove(@Param("msgId") String msgId);

    @Update("update  message set numberLove=numberLove-1 where msgId=#{msgId};")
    int deletenumberLove(@Param("msgId") String msgId);

    @Update("update  message set numberComment=numberComment+1 where msgId=#{msgId};")
    int addnumberComment(@Param("msgId") String msgId);

    @Update("update  message set numberComment=numberComment-1 where msgId=#{msgId};")
    int deletenumberComment(@Param("msgId") String msgId);

}