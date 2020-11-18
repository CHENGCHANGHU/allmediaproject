package com.seu.seumedia.entity;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/11/7 11:57
 */
public class ReceivedComment {
    private  String article_id;
    private String author_id;
    private String content;
    private int type;

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReceivedComment{" +
                "article_id='" + article_id + '\'' +
                ", author_id='" + author_id + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                '}';
    }
}
