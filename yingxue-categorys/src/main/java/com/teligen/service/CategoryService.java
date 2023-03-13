package com.teligen.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.teligen.dao.CategoryMapper;
import com.teligen.entity.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * @author liangtao
 * @date 2023-03-13 20:08
 * @desc: TODO
 *
 */

@Service
@Transactional
public class CategoryService{

    @Resource
    private CategoryMapper categoryMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

    
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }

    public List<Category> queryByFirstLevel() {
        return categoryMapper.findAllFirstLevelCatgorys();
    }

    public Category update(Category category){
        categoryMapper.updateByPrimaryKeySelective(category);
        return  categoryMapper.selectByPrimaryKey(category.getId());
    }
}
