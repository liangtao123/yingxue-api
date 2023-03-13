package com.teligen.controller;

import com.teligen.entity.Category;
import com.teligen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liangtao
 * @date 2023-03-13 20:12
 * @desc: 类别Controller
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category>categories(){
        List<Category>categories=categoryService.queryByFirstLevel();
        return categories;
    }


}
