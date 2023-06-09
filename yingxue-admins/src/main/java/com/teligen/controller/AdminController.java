package com.teligen.controller;

import com.teligen.constant.RedisPrefix;
import com.teligen.entity.Admin;
import com.teligen.entity.AdminDTO;
import com.teligen.service.AdminService;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2023-03-12 22:28:23
 */
@RestController
@Slf4j
public class AdminController {

    private AdminService adminService;
    private RedisTemplate redisTemplate;

    @Autowired
    public AdminController(AdminService adminService, RedisTemplate redisTemplate) {
        this.adminService = adminService;
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/tokens")
    public Map<String,String>tokens(@RequestBody Admin admin, HttpSession session){
        Map<String,String>result=new HashMap<>();
        log.info("接收到admin对象为:{}", JacksonUtils.writeValue(admin));
        // 登录
        Admin adminDB = adminService.login(admin);
        String token=session.getId();

        //登陆成功，存token
        redisTemplate.opsForValue().set(RedisPrefix.TOKEN_KEY+token,adminDB,1, TimeUnit.HOURS);

        result.put("token",token);
        return result;
    }

    @GetMapping("/admin-user")
    public AdminDTO admin(String token){
        log.info("当前token信息为:{}",token);
        Admin admin =(Admin) redisTemplate.opsForValue().get(RedisPrefix.TOKEN_KEY+token);
        AdminDTO adminDTO=new AdminDTO();
        BeanUtils.copyProperties(admin,adminDTO);
        return adminDTO;
    }


    /**
     *
     * @param token 需要登出的用户的token数据
     */
    @DeleteMapping("/tokens/{token}")
    public void logOut(@PathVariable("token")String token){
        redisTemplate.delete(RedisPrefix.TOKEN_KEY+token);
    }
}

