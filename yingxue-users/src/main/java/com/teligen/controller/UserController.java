package com.teligen.controller;

import com.teligen.entity.User;
import com.teligen.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liangtao
 * @date 2023-03-14 00:07
 * @desc: 用户controller
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Map<String,Object>getUsers(@RequestParam(value = "page",defaultValue = "1")Integer pageNo,
                                      @RequestParam(value = "pre_page" ,defaultValue = "5")Integer rows,
                                      @RequestParam(required = false) Integer id,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(required = false) String phone){
        Map<String,Object>resultMap=new HashMap<>();
        log.info("分页信息 当前页:{},每页展示个数:{}",pageNo,rows);
        log.info("搜索的值 id:{},name:{},phone:{}",id,name,phone);
        //1.根据条件进行查询同时进行分页处理
        List<User> items=userService.queryByLikeAndPage(pageNo,rows,id,name,phone);

        //2.根据条件查询总条数
        int totalCount=userService.queryCountByLikeAndPage(id,name,phone);
        log.info("当前页数list的大小:{}",items.size());
        log.info("数据总条数:{}",totalCount);

        resultMap.put("total_count",totalCount);
        resultMap.put("items",items);
        return resultMap;
    }
}
