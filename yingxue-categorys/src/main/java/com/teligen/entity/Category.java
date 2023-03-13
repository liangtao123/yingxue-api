package com.teligen.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author liangtao
 * @date 2023-03-13 20:08
 * @desc: TODO
 *
 */

/**
    * 分类
    */

//用@jsonInclude注解实体类，用来指定json数据中包含哪些数据
@JsonInclude(JsonInclude.Include.NON_NULL) //只要json中不为空的数据
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Integer id;

    /**
    * 名称
    */
    private String name;

    /**
    * 父级分类id
    */
    @JsonProperty("parent_id")
    private Integer parentId;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private List<Category>children;
}