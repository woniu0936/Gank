package com.woniu.gank.di.module;

import com.woniu.gank.data.api.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author woniu
 * @title ServiceModule
 * @description
 * @modifier
 * @date
 * @since 16/9/12 下午8:17
 */
@Module
public class ServiceModule {

    @Singleton
    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
