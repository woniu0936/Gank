package com.woniu.gank.di.component;

import com.woniu.gank.core.base.BaseActivity;
import com.woniu.gank.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author woniu
 * @title AppComponent
 * @description
 * @modifier
 * @date
 * @since 16/9/12 下午7:07
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(BaseActivity baseActivity);

}
