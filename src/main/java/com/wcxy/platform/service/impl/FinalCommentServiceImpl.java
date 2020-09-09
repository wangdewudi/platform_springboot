package com.wcxy.platform.service.impl;

import com.wcxy.platform.entity.Comment;
import com.wcxy.platform.entity.FinalComment;
import com.wcxy.platform.entity.User;
import com.wcxy.platform.service.FinalCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinalCommentServiceImpl implements FinalCommentService {


    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserLoveServiceImpl userLoveService;



    private FinalComment  finalComment;

    private List<FinalComment> finalComments;
    private List<Comment> comments;


    @Override
    public List<FinalComment> selectMsgId(String msgId,int page,String uid) {
        comments=commentService.seleteMsgId(msgId,page);
        if(comments==null)
            return null;
        finalComments=new ArrayList<FinalComment>();
        int i=0;
        User user=new User();

        for(;i<comments.size();i++){
            user=userService.selectUid(comments.get(i).getUid());
            finalComment=new FinalComment();
            finalComment.setComment(comments.get(i));
            finalComment.setHeadurl(user.getHeadurl());
            finalComment.setNickname(user.getNickname());
            if(comments.get(i).getAtId()!=null){
                user=userService.selectUid(comments.get(i).getAtId());
                finalComment.setAtname(user.getNickname());
            }
            if(userLoveService.selectone(comments.get(i).getMsgId(),uid,"comment")!=null)
                finalComment.setIslove(true);
            else finalComment.setIslove(false);
            System.out.println(finalComment);
            finalComments.add(finalComment);
        }

        return finalComments;
    }
    @Override
    public List<FinalComment> SelectComment(String msgId,int page,String uid){

        comments=commentService.seleteMsgId(msgId,page);
        if(comments==null)
            return null;
        finalComments=new ArrayList<FinalComment>();
        int i=0;
        User user=new User();

        for(;i<comments.size();i++){
            user=userService.selectUid(comments.get(i).getUid());
            finalComment=new FinalComment();
            finalComment.setComment(comments.get(i));
            finalComment.setHeadurl(user.getHeadurl());
            finalComment.setNickname(user.getNickname());
            if(comments.get(i).getAtId()!=null){
                user=userService.selectUid(comments.get(i).getAtId());
                finalComment.setAtname(user.getNickname());

            }
             if(comments.get(i).getNumberComment()>0){
                finalComment.setFinalComments(SelecttwoComment(comments.get(i).getCommentId(),1,uid));
                }
            if(userLoveService.selectone(comments.get(i).getMsgId(),uid,"comment")!=null)
                finalComment.setIslove(true);
            else finalComment.setIslove(false);

            finalComments.add(finalComment);
        }

        return finalComments;
    }

    @Override
    public List<FinalComment> SelecttwoComment(String replycommntId, int page,String uid) {

        User user = new User();
        List<FinalComment> finals = new ArrayList<FinalComment>();
        List<Comment> commentlist = new ArrayList<Comment>();
        commentlist = commentService.seleteCommentId(replycommntId, page);
        Integer j = 0;
        for (; j < commentlist.size(); j++) {
            FinalComment finalcom = new FinalComment();
            user = userService.selectUid(commentlist.get(j).getUid());
            finalcom.setComment(commentlist.get(j));
            finalcom.setHeadurl(user.getHeadurl());
            finalcom.setNickname(user.getNickname());
            if (commentlist.get(j).getAtId() != null) {
                user = userService.selectUid(commentlist.get(j).getAtId());
                finalcom.setAtname(user.getNickname());
            }
            if(userLoveService.selectone(commentlist.get(j).getMsgId(),uid,"comment")!=null)
                finalcom.setIslove(true);
            else finalcom.setIslove(false);
            finals.add(finalcom);
        }


        return finals;
    }
}
