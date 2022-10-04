package com.zhu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhu.domain.entity.User;
import com.zhu.utils.ResponseResult;


/**
 * 用户表(User)表服务接口
 *
 * @author xiaozhu
 * @since 2022-10-04 00:05:56
 */
public interface UserService extends IService<User> {

    ResponseResult getAllUsers();

}
