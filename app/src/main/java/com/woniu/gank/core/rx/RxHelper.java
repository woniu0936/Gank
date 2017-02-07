package com.woniu.gank.core.rx;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.woniu.gank.data.http.ApiException;
import com.woniu.gank.data.http.HttpResponse;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author woniu
 * @title RxHelper
 * @description
 * @modifier
 * @date
 * @since 16/10/31 下午2:56
 */

public class RxHelper {
    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    @RxLogObservable
    public static <T> Observable.Transformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    @RxLogObservable
    public static <T> Observable.Transformer<HttpResponse<T>, T> handleResult() {   //compose判断结果
        return httpResponseObservable -> httpResponseObservable.flatMap(new Func1<HttpResponse<T>, Observable<T>>() {
            @Override
            public Observable<T> call(HttpResponse<T> tGankHttpResponse) {
                if (!tGankHttpResponse.error()) {
                    return createData(tGankHttpResponse.results());
                } else {
                    return Observable.error(new ApiException("服务器返回error"));
                }
            }
        });
    }

    /**
     * 生成Observable
     *
     * @param <T>
     * @return
     */
    @RxLogObservable
    public static <T> Observable<T> createData(final T t) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

}
