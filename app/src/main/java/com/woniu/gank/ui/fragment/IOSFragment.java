package com.woniu.gank.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.woniu.gank.R;
import com.woniu.gank.core.base.RxBaseFragment;
import com.woniu.gank.data.bean.GankBean;
import com.woniu.gank.di.component.DaggerIOSComponent;
import com.woniu.gank.di.module.IOSModule;
import com.woniu.gank.presenter.IOSPresenter;
import com.woniu.gank.presenter.contract.IOSContract;
import com.woniu.gank.ui.adapter.BaseMultiTypeAdapter;
import com.woniu.gank.ui.providers.IOSViewProvider;
import com.woniu.gank.ui.widget.GankMultiStateView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.Items;

/**
 * @author woniu
 * @title IOSFragment
 * @description
 * @modifier
 * @date
 * @since 17/2/8 下午7:01
 */
public class IOSFragment extends RxBaseFragment implements IOSContract.View {

    @BindView(R.id.rlv_ios)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.state_view)
    GankMultiStateView stateView;
    private BaseMultiTypeAdapter mAdapter;
    private Items mItems;

    @Inject
    IOSPresenter mPresenter;

    public static AndroidFragment newInstance() {
        return new AndroidFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ios, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void showContent(List<GankBean> list) {
        mItems.addAll(list);
        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoadMoreContent(List<GankBean> list) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void initView() {
        mItems = new Items();
        mAdapter = new BaseMultiTypeAdapter();
        mAdapter.register(GankBean.class, new IOSViewProvider());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showError() {

    }

    @Override
    protected void inject() {
        DaggerIOSComponent.builder()
                .iOSModule(new IOSModule(this))
                .appComponent(getAppComponent())
                .build()
                .inject(this);
    }
}
