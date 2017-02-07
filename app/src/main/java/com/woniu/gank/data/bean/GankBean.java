package com.woniu.gank.data.bean;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * @author woniu
 * @title GankBean
 * @description gank通用实体类
 * @modifier
 * @date
 * @since 16/10/25 下午12:55
 */
@AutoValue
public abstract class GankBean implements Parcelable {
    /**
     * _id : 5808f2a0421aa90e6f21b41e
     * createdAt : 2016-10-21T00:36:48.978Z
     * desc : 关于SharedPreference踩的那些坑
     * publishedAt : 2016-10-25T11:35:01.586Z
     * source : web
     * type : Android
     * url : http://shaohui.me/2016/10/20/%E5%85%B3%E4%BA%8ESharedPreference%E8%B8%A9%E7%9A%84%E9%82%A3%E4%BA%9B%E5%9D%91/
     * used : true
     * who : 邵辉Vista
     */

    @SerializedName("_id")
    public abstract String id();

    @Nullable
    @SerializedName("createdAt")
    public abstract String createAt();

    @Nullable
    @SerializedName("desc")
    public abstract String desc();

    @Nullable
    @SerializedName("publishedAt")
    public abstract String publishedAt();

    @Nullable
    @SerializedName("source")
    public abstract String source();

    @Nullable
    @SerializedName("type")
    public abstract String type();

    @Nullable
    @SerializedName("url")
    public abstract String url();

    @SerializedName("used")
    public abstract boolean used();

    @Nullable
    @SerializedName("who")
    public abstract String who();

    public static TypeAdapter<GankBean> typeAdapter(Gson gson) {
        return new AutoValue_GankBean.GsonTypeAdapter(gson);
    }
}
