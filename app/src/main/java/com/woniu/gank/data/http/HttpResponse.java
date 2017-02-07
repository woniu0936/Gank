package com.woniu.gank.data.http;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/**
 * @author woniu
 * @title HttpResponse
 * @description 请求结果的同意处理类
 * @modifier
 * @date
 * @since 16/10/25 下午12:34
 */
@AutoValue
public abstract class HttpResponse<T> {

    public abstract boolean error();

    public abstract T results();

    public static <T> TypeAdapter<HttpResponse<T>> typeAdapter(Gson gson, TypeToken<? extends HttpResponse<T>> typeToken) {
        return new AutoValue_HttpResponse.GsonTypeAdapter(gson, typeToken);
    }

}
