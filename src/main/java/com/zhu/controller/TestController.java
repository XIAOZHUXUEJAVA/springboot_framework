package com.zhu.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * @author xiaozhu
 * @date 2022年10月03日 23:14                          $
 */

@RestController
@RequestMapping("/test")
@Api(tags = "测试",description = "测试相关相关接口")
public class TestController {



    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(value = "测试程序接口",notes = "helloworld")
    public String test() {
        return "hello你好, my framework project";
    }

}
