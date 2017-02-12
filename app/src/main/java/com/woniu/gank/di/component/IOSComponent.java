package com.woniu.gank.di.component;

import com.woniu.gank.di.FragmentScope;
import com.woniu.gank.di.module.IOSModule;
import com.woniu.gank.ui.fragment.IOSFragment;

import dagger.Component;

/**
 * @author woniu
 * @title AndroidComponent
 * @description
 * @modifier
 * @date
 * @since 16/10/31 上午11:31
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = IOSModule.class)
public interface IOSComponent {
    void inject(IOSFragment fragment);
}
