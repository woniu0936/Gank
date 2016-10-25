package com.woniu.gank.data.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author woniu
 * @title NetworkInterceptor
 * @description 保留intercepter, 以后扩展用
 * @modifier
 * @date
 * @since 16/9/12 下午7:58
 */
public class NetworkInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
