package com.woniu.gank.presenter;

import android.util.Log;

import com.woniu.gank.core.rx.RxHelper;
import com.woniu.gank.core.rx.RxSubscriber;
import com.woniu.gank.data.api.ApiService;
import com.woniu.gank.data.bean.GankBean;
import com.woniu.gank.di.FragmentScope;
import com.woniu.gank.presenter.contract.AndroidContract;
import com.woniu.gank.ui.fragment.AndroidFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * @author woniu
 * @title AndroidPresenter
 * @description
 * @modifier
 * @date
 * @since 16/10/31 上午11:25
 */
@FragmentScope
public class AndroidPresenter implements AndroidContract.Presenter {

    private static final String TAG = "AndroidPresenter";

    private final static int PAGE_NUM = 20;

    private ApiService mApiService;
    private AndroidContract.View mView;
    private AndroidFragment mFragment;

    private int currentPage = 1;

    @Inject
    public AndroidPresenter(ApiService mApiService, AndroidContract.View mView) {
        this.mApiService = mApiService;
        this.mView = mView;
        mFragment = (AndroidFragment) mView;
    }

    @Override
    public void detachView() {
        mView = null;
        mFragment = null;
    }

    /**
     * 加载分页数据
     */
    public void loadMoreDatas() {
        mApiService.getAndroid(PAGE_NUM, ++currentPage)
                .compose(RxHelper.handleResult())
                .compose(RxHelper.rxSchedulerHelper())
                .compose(mFragment.bindToLifecycle())
                .subscribe(new RxSubscriber<List<GankBean>>() {

                    @Override
                    public void doOnCompleted() {

                    }

                    @Override
                    public void doOnNext(List<GankBean> list) {
                        Log.d(TAG, list.toString());
                        mView.showContent(list);
                    }

                    @Override
                    public void doOnError(Throwable e) {

                    }

                });
    }

    /**
     * 加载首页数据
     */
    public void fetchDatas() {
        currentPage = 1;
        mApiService.getAndroid(PAGE_NUM, currentPage)
                .compose(RxHelper.handleResult())
                .compose(RxHelper.rxSchedulerHelper())
                .compose(mFragment.bindToLifecycle())
                .subscribe(new RxSubscriber<List<GankBean>>() {
                    @Override
                    public void doOnCompleted() {
                        mView.hideLoading();
                    }

                    @Override
                    public void doOnNext(List<GankBean> list) {
                        Log.d(TAG, list.toString());
                        mView.showContent(list);
                    }

                    @Override
                    public void doOnError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        mView.showLoading();
                    }
                });
    }
}
