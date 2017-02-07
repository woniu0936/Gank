package com.woniu.gank.di.module;

import com.woniu.gank.di.FragmentScope;
import com.woniu.gank.presenter.contract.AndroidContract;

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
public class AndroidModule {

    private final AndroidContract.View mView;

    public AndroidModule(AndroidContract.View mView) {
        this.mView = mView;
    }

    @FragmentScope
    @Provides
    AndroidContract.View provideView() {
        return this.mView;
    }
}
