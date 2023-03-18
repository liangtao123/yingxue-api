package com.teligen.controller;

import com.teligen.entity.Video;
import com.teligen.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liangtao
 * @date 2023-03-15 20:58
 * @desc: 视频controller
 */
@RestController
@Slf4j
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/videos")
//    page	是	1	页号(integer, default: 1)
//    per_page	是	1	每页项数(integer, default: 1)
//    id	否	1	视频ID
//    name	否	foo	视频名称
//    category_id	否	1	分类ID
//    uploader_name	否	foo	up主名称
    //return
    public Map<String,Object>getVideoList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                          @RequestParam(value = "per_page",defaultValue = "5")Integer rows,
                                          Integer id ,//视频id
                                          String name ,//用户名称
                                          @RequestParam(value = "category_id",required = false)String categoryId,
                                          @RequestParam(value = "uploader_name",required = false)String username){

        Map<String,Object>resultMap=new HashMap<>();
        log.info("当前页为: {}", page);
        log.info("每页显示记录数: {}", rows);
        log.info("搜索条件id是否存在:{}, id为: {}", !ObjectUtils.isEmpty(id), id);
        log.info("搜索条件name是否存在:{}, name为: {}", !ObjectUtils.isEmpty(name), name);
        log.info("搜索条件category_id是否存在:{}, category_id为: {}", !ObjectUtils.isEmpty(categoryId), categoryId);
        log.info("搜索条件uploader_name是否存在:{}, uploader_name为: {}", !ObjectUtils.isEmpty(username), username);

        //1.根据条件分页查询结果
        List<Video>videoList=videoService.queryByLike(page,rows,id,name,categoryId,username);
        //2.根据条件返回查询条数
        Long videoCnt=videoService.queryCountByLikeAndPage(id,name,categoryId,username);
        log.info("符合条件的总数: {}", videoCnt);

        resultMap.put("total_count",videoCnt);
        resultMap.put("items",videoList);
        return resultMap;
    }




}
