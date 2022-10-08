package com.zhu.enums;



/**
 * 响应枚举，用于异常的信息设置
 * @author xiaozhu
 * @date 2022年10月03日 23:40                          $
 */
public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    // 登录
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),
    SYSTEM_ERROR(500,"出现错误"),
    USERNAME_EXIST(501,"用户名已存在"),
    PHONENUMBER_EXIST(502,"手机号已存在"), EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名"),
    NO_USER_ERROR(519,"用户不存在"),
    CONTENT_NOT_NULL(519,"评论不能为空"),
    PARAMETER_ERROR(1001, "请求参数有误!"),
    LOGIN_ERROR(505,"用户名或密码错误");


    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
