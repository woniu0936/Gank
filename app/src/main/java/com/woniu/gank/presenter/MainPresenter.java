package com.woniu.gank.presenter;

import com.woniu.gank.data.api.ApiService;
import com.woniu.gank.presenter.contract.MainContract;

import javax.inject.Inject;

/**
 * @author woniu
 * @title MainPresenter
 * @description
 * @modifier
 * @date
 * @since 16/9/13 下午3:17
 */
public class MainPresenter implements MainContract.Presenter {

    private final ApiService mApiService;
    private final MainContract.View mView;

    @Inject
    public MainPresenter(ApiService apiService, MainContract.View view) {
        mApiService = apiService;
        mView = view;
//        mView.setPresenter(this);
    }

    @Override
    public void detachView() {

    }
}
