package com.seu.seumedia.service;

import com.seu.seumedia.entity.ArticleReceived;
import com.seu.seumedia.entity.Article_detail;
import com.seu.seumedia.entity.RequestForArticle;


/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/10/29 22:09
 */
public interface RichTextService {
    void addArticle(ArticleReceived article);

    void updateArticle(Article_detail articleDetail);

    Article_detail returnArticle(RequestForArticle request);
}