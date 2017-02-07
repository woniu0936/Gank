package com.woniu.gank.core.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.woniu.gank.core.GankApplication;
import com.woniu.gank.di.component.AppComponent;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author woniu
 * @title BaseFragment
 * @description fragment的基类，继承自fragmentation库的SupportFragment
 * @modifier
 * @date
 * @since 16/9/13 上午11:09
 */
public class BaseFragment extends SupportFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    /**
     * 获取AppComponent
     *
     * @return
     */
    protected AppComponent getAppComponent() {
        return ((GankApplication) _mActivity.getApplication()).getAppComponent();
    }

    /**
     * 注入依赖的组件
     */
    protected void inject() {

    }
}
