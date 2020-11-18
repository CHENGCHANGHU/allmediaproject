package com.seu.seumedia.entity;

import java.util.Date;

public class UserInfor {
    private long id;
    private long userId;
    private String realName;
    private Byte gender;
    private Date birthday;
    private String idNumber;
    private String headPortrait;
    private String description;
    private Date createBy;
    private Date modifiedBy;
    private Byte idDeleted;

    public UserInfor(long id, long userId, String realName, Byte gender, Date birthday, String idNumber, String headPortrait, String description, Date createBy, Date modifiedBy, Byte idDeleted) {
        this.id = id;
        this.userId = userId;
        this.realName = realName;
        this.gender = gender;
        this.birthday = birthday;
        this.idNumber = idNumber;
        this.headPortrait = headPortrait;
        this.description = description;
        this.createBy = createBy;
        this.modifiedBy = modifiedBy;
        this.idDeleted = idDeleted;
    }

    public UserInfor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public Date getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Byte getIdDeleted() {
        return idDeleted;
    }

    public void setIdDeleted(Byte idDeleted) {
        this.idDeleted = idDeleted;
    }
}
