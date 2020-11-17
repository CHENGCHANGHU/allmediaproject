package com.seu.seumedia.entity;

import java.io.Serializable;

public class Article_Info_Map implements Serializable{
    private long id; // main id
    private long version; //版本信息

    public Article_Info_Map(){

    }

    public Article_Info_Map(long id, long version){
        this.id =id;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
