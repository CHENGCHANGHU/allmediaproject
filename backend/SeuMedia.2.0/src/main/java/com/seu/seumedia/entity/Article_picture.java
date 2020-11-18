package com.seu.seumedia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import com.alibaba.fastjson.annotation.JSONField;

@Entity
public class Article_picture {
    @Id
    @JSONField()
    private long id;
    @Column
    @JSONField()
    private String title;
    @Column
    @JSONField()
    private long author_id;
    @Column
    @JSONField()
    private byte type;
    @Column
    @JSONField()
    private int height;
    @Column
    @JSONField()
    private int weight;
    @Column
    @JSONField()
    private int size;
    @Column
    @JSONField()
    private long article_id;
    @Column
    @JSONField()
    private long article_version;
    @Column
    @JSONField()
    private String save_url;
    @Column
    private byte idDeleted;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    public void setArticle_version(long article_version) {
        this.article_version = article_version;
    }

    public void setSave_url(String save_url) {
        this.save_url = save_url;
    }

    public void setIdDeleted(byte idDeleted) {
        this.idDeleted = idDeleted;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public byte getType() {
        return type;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getSize() {
        return size;
    }

    public long getArticle_id() {
        return article_id;
    }

    public long getArticle_version() {
        return article_version;
    }

    public String getSave_url() {
        return save_url;
    }

    public byte getIdDeleted() {
        return idDeleted;
    }
}
