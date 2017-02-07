package com.woniu.gank.di.component;

import com.woniu.gank.di.FragmentScope;
import com.woniu.gank.di.module.AndroidModule;
import com.woniu.gank.ui.fragment.AndroidFragment;

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
@Component(dependencies = AppComponent.class, modules = AndroidModule.class)
public interface AndroidComponent {
    void inject(AndroidFragment fragment);
}
