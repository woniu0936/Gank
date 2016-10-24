package com.woniu.gank.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author woniu
 * @title ActivityScope
 * @description
 * @modifier
 * @date
 * @since 16/9/13 上午11:10
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
