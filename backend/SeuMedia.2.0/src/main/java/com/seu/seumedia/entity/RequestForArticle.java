package com.seu.seumedia.entity;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/11/10 12:44
 */
public class RequestForArticle {
    private String article_id;
    private String article_version;

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getArticle_version() {
        return article_version;
    }

    public void setArticle_version(String article_version) {
        this.article_version = article_version;
    }

    @Override
    public String toString() {
        return "RequestForArticle{" +
                "article_id='" + article_id + '\'' +
                ", article_version='" + article_version + '\'' +
                '}';
    }
}
