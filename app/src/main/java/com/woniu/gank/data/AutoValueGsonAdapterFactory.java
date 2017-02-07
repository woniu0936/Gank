package com.woniu.gank.data;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * @author woniu
 * @title AutoValueGsonAdapterFactory
 * @description
 * @modifier
 * @date
 * @since 17/2/7 下午6:48
 */
@GsonTypeAdapterFactory
public abstract class AutoValueGsonAdapterFactory implements TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_AutoValueGsonAdapterFactory();
    }
}
