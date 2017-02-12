package com.woniu.gank.presenter;

import com.woniu.gank.core.rx.RxHelper;
import com.woniu.gank.core.rx.RxSubscriber;
import com.woniu.gank.data.api.ApiService;
import com.woniu.gank.data.bean.GankBean;
import com.woniu.gank.data.bean.Paginator;
import com.woniu.gank.di.FragmentScope;
import com.woniu.gank.presenter.contract.IOSContract;

import java.util.List;

import javax.inject.Inject;

/**
 * @author woniu
 * @title IOSPresenter
 * @description
 * @modifier
 * @date
 * @since 17/2/8 下午7:13
 */
@FragmentScope
public class IOSPresenter implements IOSContract.Presenter {

    private ApiService mApiService;
    private IOSContract.View mView;
    private Paginator mPaginator;

    @Inject
    public IOSPresenter(ApiService mApiService, IOSContract.View mView) {
        this.mApiService = mApiService;
        this.mView = mView;
        mPaginator = new Paginator();
    }

    @Override
    public void detachView() {

    }

    @Override
    public void fetchDatas() {
        mApiService.getIOS(mPaginator.getPageSize(), mPaginator.firstPage())
                .compose(RxHelper.handleResult())
                .compose(RxHelper.rxSchedulerHelper())
                .subscribe(new RxSubscriber<List<GankBean>>() {
                    @Override
                    public void doOnCompleted() {
                        mView.hideLoading();
                    }

                    @Override
                    public void doOnNext(List<GankBean> list) {
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
