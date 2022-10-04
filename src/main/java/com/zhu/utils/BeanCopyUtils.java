package com.zhu.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 拷贝工具类
 * @author xiaozhu
 * @date 2022年05月22日 16:25                          $
 */
public class BeanCopyUtils {


    private BeanCopyUtils(){

    }

    /*
     * 单个的拷贝方法
     * @author xiaozhu
     * @date 2022/5/22 16:30
     * @param source
     * @param clazz
     * @return V
     */
    public static <V> V copyBean(Object source, Class<V> clazz) {

        V result = null;
        try {
            result = clazz.newInstance();
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /*
     * List集合的拷贝方法
     * @author xiaozhu
     * @date 2022/5/22 16:38
     * @param list
     * @param clazz
     * @return java.util.List<V>
     */
    //第一个<O, V>是方法使用泛型, List<V>是返回类型
    public static <O, V> List<V> copyBeanList(List<O> list, Class<V> clazz){



        return list.stream()
                //先将的单个转化为拷贝的，然后直接收集程集合
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());

    }


}
