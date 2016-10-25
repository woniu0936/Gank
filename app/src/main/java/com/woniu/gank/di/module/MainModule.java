package com.woniu.gank.di.module;

import com.woniu.gank.di.ActivityScope;
import com.woniu.gank.presenter.contract.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author woniu
 * @title MainModule
 * @description
 * @modifier
 * @date
 * @since 16/9/13 下午12:40
 */
@Module
public class MainModule {

    private final MainContract.View mView;

    public MainModule(MainContract.View mView) {
        this.mView = mView;
    }

    @ActivityScope
    @Provides
    MainContract.View provideView() {
        return this.mView;
    }
}
