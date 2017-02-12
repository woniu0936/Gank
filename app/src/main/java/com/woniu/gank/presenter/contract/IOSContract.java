package com.woniu.gank.presenter.contract;

import com.woniu.gank.core.base.BasePresenter;
import com.woniu.gank.core.base.BaseView;
import com.woniu.gank.data.bean.GankBean;

import java.util.List;

/**
 * @author woniu
 * @title IOSContract
 * @description
 * @modifier
 * @date
 * @since 17/2/8 下午7:02
 */
public interface IOSContract {

    interface View extends BaseView {

        void showContent(List<GankBean> list);

        void showLoadMoreContent(List<GankBean> list);

    }

    interface Presenter extends BasePresenter {
        void fetchDatas();
    }
}
