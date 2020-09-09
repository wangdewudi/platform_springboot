package com.wcxy.platform.service;

import com.wcxy.platform.entity.FinalComment;

import java.util.List;

public interface FinalCommentService {

     List<FinalComment> selectMsgId(String msgId,int page,String uid);

     List<FinalComment> SelectComment(String msgId,int page,String uid);

     List<FinalComment> SelecttwoComment(String msgId,int page,String uid);

}
