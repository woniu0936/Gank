package com.woniu.gank.di.module;

import android.app.Activity;

import com.woniu.gank.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author woniu
 * @title ActivityModule
 * @description
 * @modifier
 * @date
 * @since 16/9/14 下午3:16
 */
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @ActivityScope
    @Provides
    Activity provideActivity() {
        return mActivity;
    }

}
