package com.zhu.controller;

import com.zhu.mapper.UserMapper;
import com.zhu.service.UserService;
import com.zhu.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaozhu
 * @date 2022年10月04日 0:23                          $
 */

@RestController
@RequestMapping("/user")
@Api(tags = "用户接口", description = "用户相关")
public class UserController {




    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public ResponseResult getAllUsers() {
        return userService.getAllUsers();
    }



}
