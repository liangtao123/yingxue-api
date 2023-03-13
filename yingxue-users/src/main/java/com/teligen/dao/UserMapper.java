package com.teligen.dao;

import com.teligen.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @author liangtao
 * @date 2023-03-14 00:01
 * @desc: TODO
 *
 */

@Mapper
public interface UserMapper {
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
    int insert(User record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(User record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    User selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(User record);

    List<User>queryByLikeAndPage(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") Integer id,@Param("name") String name, @Param("phone") String phone );

    int queryCountByLikeAndPage(@Param("id") Integer id,@Param("name") String name,@Param("phone") String phone);
}