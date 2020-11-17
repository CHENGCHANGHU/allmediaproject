package com.seu.seumedia.service.impl;

import com.seu.seumedia.entity.ArticleReceived;
import com.seu.seumedia.entity.Article_Info;
import com.seu.seumedia.entity.Article_detail;
import com.seu.seumedia.entity.RequestForArticle;
import com.seu.seumedia.mapper.RichTextManagerMapper;
import com.seu.seumedia.service.RichTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/10/29 22:09
 */
@SuppressWarnings("all")
@Service
public class RichTextServiceImpl implements RichTextService {
    @Autowired
    private RichTextManagerMapper richTextManagerMapper;

    @Override
    @Transactional
    public void addArticle(ArticleReceived article) {
        if ("".equals(article.getArticle_id())) {
            Article_Info articleInfo = new Article_Info();
            articleInfo.setTitle(article.getTitle());
            articleInfo.setUser_id(article.getUser_id());
            articleInfo.setLevel((byte) article.getLevel());
            articleInfo.setCreate_by(new Timestamp(System.currentTimeMillis()));
            articleInfo.setModified_by(new Timestamp(System.currentTimeMillis()));
            articleInfo.setCommited_by(new Timestamp(System.currentTimeMillis()));
            if (richTextManagerMapper.articleExists(articleInfo) == null) {
                richTextManagerMapper.addArticleInfo(articleInfo);
                Article_detail articleDetail = new Article_detail();
                articleDetail.setArticle_id(articleInfo.getId());
                articleDetail.setTitle(article.getTitle());
                articleDetail.setAuthor_id(article.getUser_id());
                articleDetail.setContent(article.getContent());
                articleDetail.setCategory(article.getCategory());
                articleDetail.setOriginality(article.getOriginality());
                richTextManagerMapper.addArticleDetail(articleDetail);
            }
        }

    }

    @Override
    @Transactional
    public void updateArticle(Article_detail articleDetail) {
        Article_Info articleInfo = new Article_Info();
        articleInfo.setId(Long.valueOf(articleDetail.getArticle_id()));
        articleInfo.setTitle(articleDetail.getTitle());
        articleInfo.setModified_by(new Timestamp(System.currentTimeMillis()));
        richTextManagerMapper.updateArticleInfo(articleInfo);
        richTextManagerMapper.updateArticleDetail(articleDetail);

    }

    @Override
    public Article_detail returnArticle(RequestForArticle request) {
        return richTextManagerMapper.selectArticleByIdAndVer(request);
    }
}