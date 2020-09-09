package com.wcxy.platform.service;

import com.wcxy.platform.entity.Comment;

import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 14:31:05
 */
public interface CommentService {

    void insert(Comment record);

    void update(Comment record);

    void addLove(String commentId,String uid);

    void deleteLove(String commentId,String uid);

    void addComment(String commentId);

    void deleteComment(String commentId);

    void delete(Integer id);

    List<Comment> seleteMsgId(String msgId,int page);

    List<Comment> seleteCommentId(String replycommentId,int page);


}