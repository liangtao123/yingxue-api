package com.teligen.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author liangtao
 * @date 2023-03-14 00:01
 * @desc: TODO
 *
 */

/**
    * 用户
    */
public class User implements Serializable {
    private Integer id;

    /**
    * 用户名
    */
    private String name;

    /**
    * 头像链接
    */
    private String avatar;

    /**
    * 简介
    */
    private String intro;

    /**
    * 手机号
    */
    private String phone;

    /**
    * 是否绑定手机号
    */
    @JsonProperty("phone_linked")
    private Boolean phoneLinked;

    /**
    * 微信openid
    */
    private String openid;

    /**
    * 是否绑定微信
    */
    @JsonProperty("wechat_linked")
    private Boolean wechatLinked;

    /**
    * 关注数
    */
    private Integer followingCount;

    /**
    * 粉丝数
    */
    private Integer followersCount;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Boolean getPhoneLinked() {
        return phoneLinked;
    }

    public void setPhoneLinked(Boolean phoneLinked) {
        this.phoneLinked = phoneLinked;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Boolean getWechatLinked() {
        return wechatLinked;
    }

    public void setWechatLinked(Boolean wechatLinked) {
        this.wechatLinked = wechatLinked;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}