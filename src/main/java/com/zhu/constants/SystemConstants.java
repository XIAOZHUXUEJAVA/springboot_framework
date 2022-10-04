package com.zhu.constants;

/**
 * 系统常量类
 * @author xiaozhu
 * @date 2022年10月03日 23:34                          $
 */
public class SystemConstants {



    //与数据库中的status相对应，任何位置需要修改的话，我们只需要修改这里的值即可


    //草稿状态  status为 1 说明是不正常的状态
    public static final int ARTICLE_STATUS_DRAFT = 1;


    //查看article表  status为 0 说明是正常发布状态
    public static final int ARTICLE_STATUS_NORMAL = 0;



    //友链Link审核是否通过
    public static final String  LINK_STATUS_NORMAL = "0";

    //文章评论
    public static final String ARTICLE_COMMENT = "0";

    //友链评论
    public static final String LINK_COMMENT = "1";

}
