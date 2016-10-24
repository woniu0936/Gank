package com.woniu.gank.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author woniu
 * @title AppModule
 * @description
 * @modifier
 * @date
 * @since 16/9/12 下午7:07
 */
@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return mApplication;
    }

}
