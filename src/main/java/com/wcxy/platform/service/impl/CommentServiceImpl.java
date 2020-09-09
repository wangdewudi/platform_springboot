package com.wcxy.platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcxy.platform.Mapper.CommentMapper;
import com.wcxy.platform.entity.Campus;
import com.wcxy.platform.entity.Comment;
import com.wcxy.platform.entity.Message;
import com.wcxy.platform.entity.UserLove;
import com.wcxy.platform.service.CommentService;
import com.wcxy.platform.tools.Getpage;
import com.wcxy.platform.tools.myrandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2020-07-17 14:31:05
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper mapper;

    @Autowired
    private UserLoveServiceImpl userLoveService;

    @Autowired
    private UserRankServiceImpl userRankService;

    @Autowired
    private UnreadServiceImpl unreadService;

    private UserLove userLove;

    private Comment comment;


    @Override
    public void insert(Comment record) {
        myrandom random=new myrandom();
        String commentId=random.getRandomString(11);
        record.setCommentId(commentId);
        record.setChecked("0");
        while(mapper.insertSelective(record)==0){
            commentId=random.getRandomString(11);
            record.setCommentId(commentId);
        }
        if(record.getReplycommentId()==null)
        this.addComment(commentId);
        else  this.addComment(record.getReplycommentId());

    }

    @Override
    public void update(Comment record) {

    }

    @Override
    public void addLove(String commentId,String uid) {

        userLove=new UserLove();
        userLove.setMsgId(commentId);
        userLove.setAdmirerUid(uid);
        userLove.setType("comment");
        userLove.setTime(new Date());
        Comment comment=new Comment();
        comment.setCommentId(commentId);
        comment=mapper.selectOne(comment);
        userLove.setUid(comment.getUid());
        if(userLoveService.insert(userLove)!=0) {
            mapper.addlove(commentId);
            userRankService.addLove(comment.getUid());
            unreadService.addLove(comment.getUid());

        }

    }

    @Override
    public void deleteLove(String commentId,String uid)
    {
        userLove=new UserLove();
        userLove.setMsgId(commentId);
        userLove.setAdmirerUid(uid);
        userLove.setType("comment");
        userLove.setTime(new Date());
        Comment comment=new Comment();
        comment.setCommentId(commentId);
        comment=mapper.selectOne(comment);
        userLove.setUid(comment.getUid());
        if(userLoveService.insert(userLove)!=0) {
            mapper.deletelove(commentId);
            userRankService.deleteLove(comment.getUid());
            unreadService.deleteLove(comment.getUid());

        }

    }

    @Override
    public void addComment(String commentId) {
        mapper.addcomment(commentId);
    }

    @Override
    public void deleteComment(String commentId) {
        mapper.deletecomment(commentId);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Comment> seleteMsgId(String msgId,int page) {

        Example example = new Example(Comment.class);
        Example.Criteria criteria= example.createCriteria();
        criteria.andEqualTo("msgId",msgId);
        criteria.andEqualTo("replycommentId","0");

        

        example.setOrderByClause("timeSend desc ");

        //查询
        PageHelper.startPage(page, 5,false);
        List<Comment> comments = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(comments)) {
            return null;
        }
        Getpage getpage=new Getpage();
        //解析分页结果
        System.out.println(comments);
        comments=getpage.getComment( new PageInfo<Comment>(comments));



        return comments;

    }

    @Override
    public List<Comment> seleteCommentId(String replycommentId,int page) {
            Example example = new Example(Comment.class);
        example.createCriteria().andEqualTo("replycommentId",replycommentId);




        example.setOrderByClause("timeSend desc ");

        //查询
        PageHelper.startPage(page, 5,false);
        List<Comment> comments = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(comments)) {
            return null;
        }
        Getpage getpage=new Getpage();
        //解析分页结果
        comments=getpage.getComment( new PageInfo<Comment>(comments));



        return comments;

    }
}
