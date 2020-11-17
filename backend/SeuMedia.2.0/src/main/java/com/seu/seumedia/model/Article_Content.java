package com.seu.seumedia.model;

import com.seu.seumedia.entity.Article_detail;
import java.sql.Timestamp;

public class Article_Content extends Article_detail{
    private Timestamp commited_time;
    private Timestamp published_time;
    private int level;
    private String author_name;

    public Timestamp getCommited_time() {
        return commited_time;
    }

    public Timestamp getPublished_time() {
        return published_time;
    }

    public int getLevel() {
        return level;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setCommited_time(Timestamp commited_time) {
        this.commited_time = commited_time;
    }

    public void setPublished_time(Timestamp published_time) {
        this.published_time = published_time;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}
