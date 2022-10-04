package com.zhu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhu.domain.entity.User;
import com.zhu.mapper.UserMapper;
import com.zhu.service.UserService;
import com.zhu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表(User)表服务实现类
 *
 * @author xiaozhu
 * @since 2022-10-04 00:06:26
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public ResponseResult getAllUsers() {

        List<User> users = userMapper.selectList(null);
        return ResponseResult.okResult(users);

    }

}
