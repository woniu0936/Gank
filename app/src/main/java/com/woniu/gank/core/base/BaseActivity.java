package com.woniu.gank.core.base;

import com.woniu.gank.core.GankApplication;
import com.woniu.gank.di.component.AppComponent;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * @author woniu
 * @title BaseActivity
 * @description activity的基类，继承自fragmentation库的SupportActivity
 * @modifier
 * @date
 * @since 16/9/13 上午11:09
 */
public class BaseActivity extends SupportActivity {

    /**
     * 获取AppComponent
     *
     * @return
     */
    protected AppComponent getAppComponent() {
        return ((GankApplication) getApplication()).getAppComponent();
    }

}
