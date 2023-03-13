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

    @PatchMapping("{id}")
    public Category update(@PathVariable("id")Integer id,@RequestBody Category category){
        //打印更新类别日志
        log.info("修改的类别id为:{}",id);
        log.info("修改的类别信息为:{}", JacksonUtils.writeValue(category));
        category.setId(id);
        return categoryService.update(category);
    }

}
