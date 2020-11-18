package com.seu.seumedia.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@IdClass(Article_Info_Map.class)
public class Article_Info {
    @Id
    @JSONField()
    private long version; // version infomation
    @Id
    @JSONField()
    private long id; // article_id
    @Column
    @JSONField()
    private String title; //article title
    @Column
    @JSONField()
    private Integer status; //article check status   和数据库中数据类型不对应，应该是byte，但是考虑取值不一定暂不动
    @Column
    @JSONField()
    private byte level; // article level
    @Column
    @JSONField()
    private long user_id; //article poster
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp create_by; //article creating time
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp commited_by; //article commiting time
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp published_by; //article publicing time
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp modified_by;
    @Column
    private byte idDeleted; //delete the tag bit

    public Article_Info(){
    }
    public Article_Info(long id, long version){
        this.id = id;
        this.version = version;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setCreate_by(Timestamp create_by) {
        this.create_by = create_by;
    }

    public void setCommited_by(Timestamp commited_by) {
        this.commited_by = commited_by;
    }

    public void setPublished_by(Timestamp published_by) {
        this.published_by = published_by;
    }

    public void setModified_by(Timestamp modified_by) {
        this.modified_by = modified_by;
    }

    public void setIdDeleted(byte idDeleted) {
        this.idDeleted = idDeleted;
    }

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public String getTitle() {
        return title;
    }

    public Integer getStatus() {
        return status;
    }

    public byte getLevel() {
        return level;
    }

    public long getUser_id() {
        return user_id;
    }

    public Timestamp getCreate_by() {
        return create_by;
    }

    public Timestamp getCommited_by() {
        return commited_by;
    }

    public Timestamp getPublished_by() {
        return published_by;
    }

    public Timestamp getModified_by() {
        return modified_by;
    }

    public byte getIdDeleted() {
        return idDeleted;
    }
}


