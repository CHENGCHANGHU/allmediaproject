package com.seu.seumedia.entity;

public class MediaUserInfo {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String userStatus;

    public MediaUserInfo(Long id, String username, String password, String phone, String email, String userStatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.userStatus = userStatus;
    }

    public MediaUserInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}