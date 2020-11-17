package com.seu.seumedia.mapper;

import com.seu.seumedia.entity.Article_Info;
import com.seu.seumedia.entity.Article_detail;
import com.seu.seumedia.entity.RequestForArticle;
import org.springframework.stereotype.Repository;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/10/29 22:30
 */
@Repository
public interface RichTextManagerMapper {
    void addArticleInfo(Article_Info articleInfo);
    void addArticleDetail(Article_detail articleDetail);
    Article_Info articleExists(Article_Info article_info);

    void updateArticleInfo(Article_Info articleInfo);
    void updateArticleDetail(Article_detail articleDetail);

    Article_detail selectArticleByIdAndVer(RequestForArticle request);
}
