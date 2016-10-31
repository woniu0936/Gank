package com.woniu.gank.core.base;

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

    /**
     * 获取AppComponent
     * @return
     */
    protected AppComponent getAppComponent() {
        return ((GankApplication) _mActivity.getApplication()).getAppComponent();
    }
}
