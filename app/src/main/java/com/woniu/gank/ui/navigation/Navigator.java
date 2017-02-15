package com.woniu.gank.ui.navigation;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author woniu
 * @title Navigator
 * @description
 * @modifier
 * @date
 * @since 16/9/13 下午2:14
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
    }

    public void log(int position) {
        Log.d("Navigator", "test inject provide " + position);
    }
}
