package com.woniu.gank.core;

/**
 * @author woniu
 * @title AppConfig
 * @description
 * @modifier
 * @date
 * @since 16/9/12 下午7:11
 */
public class AppConfig {
    /**
     * 标记是否输出debug信息
     */
    public static boolean DEBUG = false;

    /**
     * http
     */
    public static final long RESPONSE_CACHE_SIZE = 10 * 1024 * 1024;
    public static final int HTTP_CONNECT_TIMEOUT = 20 * 1000;
    public static final int HTTP_READ_TIMEOUT = 20 * 1000;
}
