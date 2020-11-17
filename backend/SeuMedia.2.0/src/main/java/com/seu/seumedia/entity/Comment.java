package com.seu.seumedia.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/28 20:56
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 6676370140317887989L;
    private BigInteger id;
    private BigInteger article_id;
    private String content;
    private BigInteger author_id;
    private String ip;
    private String create_by;
    private String modified_by;
    private int is_effect;
    private int isDeleted;
    private int type;

    private List<Comment> secondLevelComment;

    public List<Comment> getSecondLevelComment() {
        return secondLevelComment;
    }

    public void setSecondLevelComment(List<Comment> secondLevelComment) {
        this.secondLevelComment = secondLevelComment;
    }

    public int getType() {
        return type;
    }

    public BigInteger getArticle_id() {
        return article_id;
    }

    public void setArticle_id(BigInteger article_id) {
        this.article_id = article_id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigInteger getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(BigInteger author_id) {
        this.author_id = author_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public int getIs_effect() {
        return is_effect;
    }

    public void setIs_effect(int is_effect) {
        this.is_effect = is_effect;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int idDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", content='" + content + '\'' +
                ", author_id=" + author_id +
                ", ip='" + ip + '\'' +
                ", create_by='" + create_by + '\'' +
                ", modified_by='" + modified_by + '\'' +
                ", is_effect=" + is_effect +
                ", isDeleted=" + isDeleted +
                ", type=" + type +
                ", secondLevelComment=" + secondLevelComment +
                '}';
    }
}
