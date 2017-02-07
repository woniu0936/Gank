package com.woniu.gank.presenter.contract;

import com.woniu.gank.core.base.BasePresenter;
import com.woniu.gank.core.base.BaseView;
import com.woniu.gank.data.bean.CommonBean;

import java.util.List;

/**
 * @author woniu
 * @title AndroidContract
 * @description
 * @modifier
 * @date
 * @since 16/10/31 上午11:23
 */

public interface AndroidContract {

    interface View extends BaseView {

        void showContent(List<CommonBean> list);

        void showLoadMoreContent(List<CommonBean> list);

    }

    interface Presenter extends BasePresenter {

    }
}
