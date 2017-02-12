package com.woniu.gank.di.module;

import com.woniu.gank.di.FragmentScope;
import com.woniu.gank.presenter.contract.IOSContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author woniu
 * @title AndroidModule
 * @description
 * @modifier
 * @date
 * @since 16/10/31 上午11:28
 */
@Module
public class IOSModule {

    private final IOSContract.View mView;

    public IOSModule(IOSContract.View mView) {
        this.mView = mView;
    }

    @FragmentScope
    @Provides
    IOSContract.View provideView() {
        return this.mView;
    }
}
