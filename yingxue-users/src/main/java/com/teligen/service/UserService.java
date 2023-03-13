package com.teligen.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.teligen.dao.UserMapper;
import com.teligen.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * @author liangtao
 * @date 2023-03-14 00:01
 * @desc: TODO
 *
 */

@Service
@Transactional
public class UserService{

    @Resource
    private UserMapper userMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(User record) {
        return userMapper.insert(record);
    }

    
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }


    public List<User> queryByLikeAndPage(Integer pageNo, Integer rows, Integer id, String name, String phone) {
        int start=(pageNo-1)*rows;
        return userMapper.queryByLikeAndPage(start,rows,id,name,phone);
    }

    public int queryCountByLikeAndPage(Integer id, String name, String phone) {
        return userMapper.queryCountByLikeAndPage(id,name,phone);
    }
}
