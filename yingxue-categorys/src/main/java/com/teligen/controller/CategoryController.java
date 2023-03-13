package com.teligen.controller;

import com.teligen.entity.Category;
import com.teligen.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.JacksonUtils;

import java.util.List;

/**
 * @author liangtao
 * @date 2023-03-13 20:12
 * @desc: 类别Controller
 */
@RestController
@RequestMapping("/categories")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * 获取所有视频类别
     * @return
     */
    @GetMapping
    public List<Category>categories(){
        List<Category>categories=categoryService.queryByFirstLevel();
        return categories;
    }

    /**
     *
     * @desc: 修改类别信息接口
     * @param id 需要修改的类别id
     * @param category 需要修改的信息 主要取name parentId字段
     * @return category 修改后的类别信息，并更新修改时间 updatedAt
     */
    @PatchMapping("{id}")
    public Category update(@PathVariable("id")Integer id,@RequestBody Category category){
        //打印更新类别日志
        log.info("修改的类别id为:{}",id);
        log.info("修改的类别信息为:{}", JacksonUtils.writeValue(category));
        category.setId(id);
        return categoryService.update(category);
    }

    /**
     *
     * @param category 需要添加的类别信息 主要取name parentId字段
     * @return
     */
    @PostMapping
    public Category add(@RequestBody Category category){
        log.info("需要添加的类别信息:{}",JacksonUtils.writeValue(category));

        Category category1 = categoryService.addCategory(category);
        log.info("添加之后的类别信息:{}",JacksonUtils.writeValue(category1));
        return category1;

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id")Integer id){
        log.info("需要删除的类别id:{}");
        categoryService.deleteByPrimaryKey(id);
    }

}
