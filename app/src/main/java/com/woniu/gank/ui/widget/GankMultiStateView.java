package com.woniu.gank.ui.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.woniu.gank.R;

/**
 * @author woniu
 * @title GankMultiStateView
 * @description
 * @modifier
 * @date
 * @since 16/12/8 下午6:14
 */
public class GankMultiStateView extends MultiStateView {

    public GankMultiStateView(Context context) {
        super(context);
        initDefaultView();
    }

    public GankMultiStateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDefaultView();
    }

    public GankMultiStateView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initDefaultView();
    }

    /**
     * 添加默认的loading，error，empty的view
     */
    private void initDefaultView() {
        if (isLoadingViewNull()) {
            setViewForState(R.layout.multi_view_loading, VIEW_STATE_LOADING);
        }
        if (isErrorViewNull()) {
            setViewForState(R.layout.multi_view_error, VIEW_STATE_ERROR);
        }
        if (isEmptyViewNull()) {
            setViewForState(R.layout.multi_view_empty, VIEW_STATE_EMPTY);
        }
    }

}
