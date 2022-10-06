package com.zhu.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 如果记不住这个注解也没关系 直接使用Around注解 然后在里面查看结课==即可
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLog {

    // 业务名称
    String businessName();
}
