package com.seu.seumedia.service;

import com.seu.seumedia.entity.Comment;
import com.seu.seumedia.entity.ReceivedComment;

import java.util.List;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/28 20:26
 */
public interface CommentService {
    void addComment(ReceivedComment comment, String userIP);
    List<Comment> showAllCommentByArticle(String article_id);

    List<Comment> showAllCommentByUser(String author_id);
}

