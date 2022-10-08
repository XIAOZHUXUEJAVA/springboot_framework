package com.zhu.controller;

import com.zhu.annoation.SystemLog;
import com.zhu.domain.entity.User;
import com.zhu.mapper.UserMapper;
import com.zhu.service.UserService;
import com.zhu.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @SystemLog(businessName = "获取所有用户")
    public ResponseResult getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public  ResponseResult saveUser(@RequestBody @Valid User user) {
        userService.save(user);

        return ResponseResult.okResult();

    }


}
