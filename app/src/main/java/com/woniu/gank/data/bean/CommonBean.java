package com.woniu.gank.data.bean;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * @author woniu
 * @title CommonBean
 * @description
 * @modifier
 * @date
 * @since 17/2/6 下午8:02
 */
@AutoValue
public abstract class CommonBean implements Parcelable {

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

    public static TypeAdapter<CommonBean> typeAdapter(Gson gson) {
        return new AutoValue_CommonBean.GsonTypeAdapter(gson);
    }

}
