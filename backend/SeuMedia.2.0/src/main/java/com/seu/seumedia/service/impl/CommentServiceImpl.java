package com.seu.seumedia.service.impl;

import com.seu.seumedia.entity.Comment;
import com.seu.seumedia.entity.ReceivedComment;
import com.seu.seumedia.mapper.CommentMapper;
import com.seu.seumedia.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/28 20:27
 */
@Service
@SuppressWarnings("all")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    @Transactional
    public void addComment(ReceivedComment comment, String ip) {
        Comment newComment = new Comment();
        newComment.setContent(comment.getContent());
        newComment.setAuthor_id(new BigInteger(comment.getAuthor_id()));
        newComment.setIp(ip);
        newComment.setType(Integer.valueOf(comment.getType()));
        newComment.setArticle_id(new BigInteger(comment.getArticle_id()));
        newComment.setCreate_by(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        commentMapper.addComment(newComment);
        commentMapper.addArticleComment(newComment);
    }

    @Override
    @Transactional
    public List<Comment> showAllCommentByArticle(String article_id) {
        List<Comment> commentList = commentMapper.selectCommentByArticleId(new BigInteger(article_id));
        commentList.forEach((comment) -> comment.setSecondLevelComment(commentMapper.selectCommentByArticleId(comment.getId())));
        return commentList;
    }

    @Override
    public List<Comment> showAllCommentByUser(String author_id) {
        return  commentMapper.selectCommentByUserId(new BigInteger(author_id));
    }
}
