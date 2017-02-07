package com.woniu.gank.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jakewharton.rxbinding.support.v4.widget.RxSwipeRefreshLayout;
import com.jakewharton.rxbinding.support.v7.widget.RxRecyclerView;
import com.trello.rxlifecycle.android.FragmentEvent;
import com.woniu.gank.R;
import com.woniu.gank.core.base.RxBaseFragment;
import com.woniu.gank.data.bean.GankBean;
import com.woniu.gank.di.component.DaggerAndroidComponent;
import com.woniu.gank.di.module.AndroidModule;
import com.woniu.gank.presenter.AndroidPresenter;
import com.woniu.gank.presenter.contract.AndroidContract;
import com.woniu.gank.ui.adapter.AndroidAdapter;
import com.woniu.gank.ui.widget.GankMultiStateView;
import com.woniu.gank.ui.widget.MultiStateView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author woniu
 * @title AndroidFragment
 * @description
 * @modifier
 * @date
 * @since 16/10/31 上午11:21
 */

public class AndroidFragment extends RxBaseFragment implements AndroidContract.View {

    private static final String TAG = AndroidFragment.class.getSimpleName();

    @BindView(R.id.rlv_android)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.state_view)
    GankMultiStateView mStateView;

    @Inject
    AndroidPresenter mPresenter;

    private LinearLayoutManager mLayoutManager;
    private AndroidAdapter mAdapter;
    private int lastVisibleItemPosition;

    public static AndroidFragment newInstance() {
        return new AndroidFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Preconditions.checkNotNull(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void initView() {

        // 设置下拉圆圈上的颜色，蓝色、绿色、橙色、红色
        mSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        mLayoutManager = new LinearLayoutManager(_mActivity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AndroidAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mPresenter.fetchDatas();

        RxSwipeRefreshLayout.refreshes(mSwipeRefreshLayout)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY_VIEW))
                .subscribe(aVoid -> {
                    mPresenter.fetchDatas();
                });

        RxRecyclerView.scrollEvents(mRecyclerView)
                .filter(event -> {
                    lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition();
                    Log.d(TAG, "data size : " + mAdapter.getData().size());
                    Log.d(TAG, "lastVisibleItemPosition : " + lastVisibleItemPosition);
                    return event.dy() > 0;
                })
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY_VIEW))
                .subscribe(event -> {
                    //加载分页数据
//                    mPresenter.loadMoreDatas();
                });
    }

    @Override
    protected void inject() {
        DaggerAndroidComponent.builder()
                .androidModule(new AndroidModule(this))
                .appComponent(getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    public void showContent(List<GankBean> list) {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        mAdapter.setNewData(list);
    }

    @Override
    public void showLoadMoreContent(List<GankBean> list) {
        mAdapter.addData(list);
    }

    @Override
    public void showLoading() {
        if (!mSwipeRefreshLayout.isRefreshing()) {
            mStateView.setViewState(MultiStateView.VIEW_STATE_LOADING);
        }
    }

    @Override
    public void hideLoading() {
        if (!mSwipeRefreshLayout.isRefreshing()) {
            mStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
        }
    }

    @Override
    public void showError() {
        if (mSwipeRefreshLayout.isRefreshing()) mSwipeRefreshLayout.setRefreshing(false);
        mStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
    }
}
