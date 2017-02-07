package com.woniu.gank.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author woniu
 * @title BaseAdapter
 * @description
 * @modifier
 * @date
 * @since 16/11/8 下午10:11
 */

public abstract class BaseAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {

    public BaseAdapter(int layoutResId, List<T> data) {
        super(layoutResId, data);
    }

    /**
     * 清除数据
     */
    public void clear() {
        getData().clear();
    }
}
