package com.woniu.gank.core;

import android.app.Application;

import com.woniu.gank.data.api.ApiService;
import com.woniu.gank.di.component.AppComponent;
import com.woniu.gank.di.component.DaggerAppComponent;
import com.woniu.gank.di.module.AppModule;
import com.woniu.gank.di.module.ClientModule;
import com.woniu.gank.di.module.ServiceModule;

/**
 * @author woniu
 * @title GankApplication
 * @description
 * @modifier
 * @date
 * @since 16/10/21 下午6:11
 */

public class GankApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(getAppModule())
                .clientModule(getClientModule())
                .serviceModule(getServiceModule())
                .build();
    }

    private AppModule getAppModule() {
        return new AppModule(this);
    }

    private ClientModule getClientModule() {
        return ClientModule.builder()
                .baseUrl(ApiService.baseUrl)
                .build();
    }

    private ServiceModule getServiceModule() {
        return new ServiceModule();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
