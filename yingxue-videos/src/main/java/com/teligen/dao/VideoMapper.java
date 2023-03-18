package com.teligen.dao;

import com.teligen.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @author liangtao
 * @date 2023-03-15 21:15
 * @desc: TODO
 *
 */

@Mapper
public interface VideoMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Video record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Video record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Video selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Video record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Video record);

    List<Video> queryByLike(@Param("start") int start, @Param("rows") Integer rows, @Param("id") Integer id, @Param("title") String name, @Param("categoryId") String categoryId, @Param("username") String username);

    Long queryCountByKeyWords(@Param("id") Integer id,@Param("title") String name, @Param("categoryId") String categoryId,@Param("username") String username);
}