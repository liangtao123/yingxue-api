package com.teligen.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.teligen.dao.VideoMapper;
import com.teligen.entity.Video;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 
 * @author liangtao
 * @date 2023-03-15 21:15
 * @desc: TODO
 *
 */

@Service
@Transactional
public class VideoService{

    @Resource
    private VideoMapper videoMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return videoMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Video record) {
        return videoMapper.insert(record);
    }

    
    public int insertSelective(Video record) {
        return videoMapper.insertSelective(record);
    }

    
    public Video selectByPrimaryKey(Integer id) {
        return videoMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Video record) {
        return videoMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Video record) {
        return videoMapper.updateByPrimaryKey(record);
    }

    public List<Video> queryByLike(Integer page, Integer rows, Integer id, String name, String categoryId, String uploaderName) {
        int start=(page-1)*rows;
        return videoMapper.queryByLike(start,rows,id,name,categoryId,uploaderName);
    }

    public Long queryCountByLikeAndPage(Integer id, String name, String categoryId, String uploaderName) {
        return videoMapper.queryCountByKeyWords(id,name,categoryId,uploaderName);
    }
}
