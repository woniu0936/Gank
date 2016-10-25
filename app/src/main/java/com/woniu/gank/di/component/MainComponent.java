package com.woniu.gank.di.component;

import com.woniu.gank.di.ActivityScope;
import com.woniu.gank.di.module.ActivityModule;
import com.woniu.gank.di.module.MainModule;
import com.woniu.gank.view.activity.MainActivity;

import dagger.Component;

/**
 * @author woniu
 * @title MainComponent
 * @description
 * @modifier
 * @date
 * @since 16/9/13 下午12:14
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, MainModule.class})
public interface MainComponent extends ActivityComponent {

    void inject(MainActivity activity);

}
