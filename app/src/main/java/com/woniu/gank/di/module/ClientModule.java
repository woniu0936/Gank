package com.woniu.gank.di.module;

import android.app.Application;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.woniu.gank.core.AppConfig;
import com.woniu.gank.core.AppConfigHelper;
import com.woniu.gank.data.AutoValueGsonAdapterFactory;
import com.woniu.gank.data.http.NetworkInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author woniu
 * @title ClientModule
 * @description
 * @modifier
 * @date
 * @since 16/9/12 下午7:17
 */
@Module
public class ClientModule {

    final private String baseUrl;

    public ClientModule(Builder builder) {
        this.baseUrl = builder.baseUrl;
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(Cache cache, Interceptor interceptor) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return configClient(builder, cache, interceptor);
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, Gson gson) {
        final Retrofit.Builder builder = new Retrofit.Builder();
        return configRetrofit(builder, client, gson);

    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(AutoValueGsonAdapterFactory.create())
                .create();
    }

    @Singleton
    @Provides
    Cache provideCache(Application application) {
        return new Cache(AppConfigHelper.getCacheFile(application), AppConfig.RESPONSE_CACHE_SIZE);
    }

    @Singleton
    @Provides
    Interceptor provideInterceptor() {
        return new NetworkInterceptor();
    }

    private OkHttpClient configClient(OkHttpClient.Builder builder, Cache cache, Interceptor interceptor) {
        OkHttpClient.Builder okBuilder = builder
                .retryOnConnectionFailure(true)
                .connectTimeout(AppConfig.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(AppConfig.HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .cache(cache)
                .addNetworkInterceptor(interceptor);
        if (AppConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);
            okBuilder.addInterceptor(loggingInterceptor);
        }
        return okBuilder.build();
    }

    private Retrofit configRetrofit(Retrofit.Builder builder, OkHttpClient client, Gson gson) {
        return builder
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//使用rxjava
                .addConverterFactory(GsonConverterFactory.create(gson))//使用Gson
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String baseUrl;

        private Builder() {
        }

        public Builder baseUrl(@NonNull String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public ClientModule build() {
            if (TextUtils.isEmpty(baseUrl)) {
                throw new NullPointerException("baseurl is not " + baseUrl);
            }
            return new ClientModule(this);
        }
    }

}
