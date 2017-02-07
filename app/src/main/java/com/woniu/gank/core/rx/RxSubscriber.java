package com.woniu.gank.core.rx;

import com.fernandocejas.frodo.annotation.RxLogSubscriber;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * @author woniu
 * @title RxSubscriber
 * @description
 * @modifier
 * @date
 * @since 16/11/7 下午11:01
 */
@RxLogSubscriber
public abstract class RxSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
//            Toast.makeText(context, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
//            Toast.makeText(context, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(context, "错误" + e.getMessage(), Toast.LENGTH_SHORT).show();
//            Log.i("tag", "error----------->" + e.toString());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

}
