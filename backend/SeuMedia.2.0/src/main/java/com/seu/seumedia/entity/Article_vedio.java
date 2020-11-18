package com.seu.seumedia.entity;


import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
@Entity
public class Article_vedio {
    @Id
    @JSONField()
    private long id;
    @Column
    @JSONField()
    private String title;
    @Column
    @JSONField()
    private int mine_type;   //对应数据库应该是byte，考虑取值先这样
    @Column
    @JSONField()
    private long author_id;
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
    private long article_id ;
    @Column
    @JSONField()
    private long article_version;
    @Column
    @JSONField()
    private String save_url;
    @Column
    @JSONField()
    private String frame_url;
    @Column
    @JSONField()
    private int duration;
    @Column
    @JSONField()
    private int vbit;
    @Column
    @JSONField()
    private BigDecimal frame_rate;
    @Column
    private byte idDeleted;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMine_type(int mine_type) {
        this.mine_type = mine_type;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
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

    public void setFrame_url(String frame_url) {
        this.frame_url = frame_url;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setVbit(int vbit) {
        this.vbit = vbit;
    }

    public void setFrame_rate(BigDecimal frame_rate) {
        this.frame_rate = frame_rate;
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

    public int getMine_type() {
        return mine_type;
    }

    public long getAuthor_id() {
        return author_id;
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

    public String getFrame_url() {
        return frame_url;
    }

    public int getDuration() {
        return duration;
    }

    public int getVbit() {
        return vbit;
    }

    public BigDecimal getFrame_rate() {
        return frame_rate;
    }

    public byte getIdDeleted() {
        return idDeleted;
    }
}
