package com.seu.seumedia.mapper;

import com.seu.seumedia.entity.Comment;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/11/7 12:20
 */
@Repository
public interface CommentMapper {
    void addComment(Comment comment);
    void addArticleComment(Comment commment);
    List<Comment> selectCommentByArticleId(BigInteger article_id);

    List<Comment> selectCommentByUserId(BigInteger bigInteger);
}
