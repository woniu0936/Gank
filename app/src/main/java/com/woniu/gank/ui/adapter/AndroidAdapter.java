package com.woniu.gank.ui.adapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.woniu.gank.R;
import com.woniu.gank.data.bean.CommonBean;

/**
 * @author woniu
 * @title AndroidAdapter
 * @description
 * @modifier
 * @date
 * @since 16/11/8 下午10:49
 */
public class AndroidAdapter extends BaseAdapter<CommonBean, BaseViewHolder> {

    public AndroidAdapter() {
        super(R.layout.item_android, null);
    }

    @Override
    protected void convert(BaseViewHolder holder, CommonBean gankBean) {
        holder.setText(R.id.tv_title, gankBean.desc())
                .setText(R.id.tv_author, gankBean.who())
                .setText(R.id.tv_time, gankBean.createAt());
    }

//    @Override
//    protected void convert(ViewHolder holder, GankBean gankBean) {
//        holder.tvAuthor.setText(gankBean.getWho());
//        holder.tvTitle.setText(gankBean.getDesc());
//        holder.tvTime.setText(gankBean.getPublishedAt());
//
//    }
//
//    class ViewHolder extends BaseViewHolder {
//
//        @BindView(R.id.iv_android_icon)
//        ImageView ivAndroidIcon;
//        @BindView(R.id.tv_title)
//        TextView tvTitle;
//        @BindView(R.id.tv_author)
//        TextView tvAuthor;
//        @BindView(R.id.tv_time)
//        TextView tvTime;
//
//        public ViewHolder(View view) {
//            super(view);
//            ButterKnife.bind(this, view);
//        }
//    }
}
