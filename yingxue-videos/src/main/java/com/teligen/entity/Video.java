package com.teligen.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author liangtao
 * @date 2023-03-15 21:15
 * @desc: TODO
 *
 */

/**
    * 视频
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Video implements Serializable {
    private Integer id;

    /**
    * 标题
    */
    private String title;

    /**
    * 简介
    */
    private String intro;

    /**
    * up主id
    */
    private Integer uid;

    /**
    * 视频封面链接
    */
    private String cover;

    /**
    * 视频播放链接
    */
    private String link;

    /**
     * 分类id
     */
    @JsonProperty("category_id")
    private Integer categoryId;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("deleted_at")
    private Date deletedAt;

    private String category; //视频名称

    private User uploader;//上传者信息



    private static final long serialVersionUID = 1L;
}