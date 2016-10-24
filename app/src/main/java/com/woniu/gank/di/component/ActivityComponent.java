package com.woniu.gank.di.component;

import android.app.Activity;

import com.woniu.gank.di.ActivityScope;
import com.woniu.gank.di.module.ActivityModule;

import dagger.Component;

/**
 * @author woniu
 * @title ActivityComponent
 * @description
 * @modifier
 * @date
 * @since 16/9/14 下午3:16
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
}
