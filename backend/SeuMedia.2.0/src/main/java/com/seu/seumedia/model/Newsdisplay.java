package com.seu.seumedia.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.seu.seumedia.entity.Article_picture;


public class Newsdisplay {
    @JSONField
    private long article_id;
    @JSONField
    private long version;
    @JSONField
    private String author_name;
    @JSONField
    private String title;
    @JSONField
    private Article_picture picture;
    @JSONField
    private String published_by;

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPicture(Article_picture picture) {
        this.picture = picture;
    }

    public void setPublished_by(String published_by) {
        this.published_by = published_by;
    }

    public long getArticle_id() {
        return article_id;
    }

    public long getVersion() {
        return version;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getTitle() {
        return title;
    }

    public Article_picture getPicture() {
        return picture;
    }

    public String getPublished_by() {
        return published_by;
    }
}
