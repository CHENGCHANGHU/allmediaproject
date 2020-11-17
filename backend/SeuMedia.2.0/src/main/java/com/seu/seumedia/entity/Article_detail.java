package com.seu.seumedia.entity;

import com.alibaba.fastjson.annotation.JSONField;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Article_detail {
    private static final long serialVersionUID = 6684125823783998493L;
    @Id
    private long id;
    @Column
    private long article_id;
    @Column
    private long article_version;
    @Column
    @JSONField(serialize = false)
    private String title;
    @Column
    @JSONField(serialize = false)
    private long author_id;
    @Column
    @JSONField(serialize = false)
    private String abstracts;
    @Column
    @JSONField(serialize = false)
    private String keywords;
    @Column
    @JSONField(serialize = false)
    private String content;
    @Column
    @JSONField(serialize = false)
    private String source;
    @Column
    @JSONField(serialize = false)
    private String category;
    @Column
    @JSONField(serialize = false)
    private String subcategory;
    @Column
    @JSONField(serialize = false)
    private String topic;
    @Column
    @JSONField(serialize = false)
    private String copyright;
    @Column
    @JSONField(serialize = false)
    private String originality;
    @Column
    private byte idDeleted;

    public void setId(long id) {
        this.id = id;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    public void setArticle_version(long article_version) {
        this.article_version = article_version;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setContent(String context) {
        this.content = context;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setOriginality(String originality) {
        this.originality = originality;
    }

    public void setIdDeleted(byte idDeleted) {
        this.idDeleted = idDeleted;
    }

    public long getId() {
        return id;
    }

    public long getArticle_id() {
        return article_id;
    }

    public long getArticle_version() {
        return article_version;
    }

    public String getTitle() {
        return title;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getContent() {
        return content;
    }

    public String getSource() {
        return source;
    }

    public String getCategory() {
        return category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public String getTopic() {
        return topic;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getOriginality() {
        return originality;
    }

    public byte getIdDeleted() {
        return idDeleted;
    }

    @Override
    public String toString() {
        return "Article_detail{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", article_version=" + article_version +
                ", title='" + title + '\'' +
                ", author_id=" + author_id +
                ", abstracts='" + abstracts + '\'' +
                ", keywords='" + keywords + '\'' +
                ", content='" + content + '\'' +
                ", source='" + source + '\'' +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", topic='" + topic + '\'' +
                ", copyright='" + copyright + '\'' +
                ", originality='" + originality + '\'' +
                ", idDeleted=" + idDeleted +
                '}';
    }
}
