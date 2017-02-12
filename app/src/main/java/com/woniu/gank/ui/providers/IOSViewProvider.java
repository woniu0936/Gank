package com.woniu.gank.ui.providers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.woniu.gank.R;
import com.woniu.gank.data.bean.GankBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewProvider;

/**
 * @author woniu
 * @title IOSViewProvider
 * @description
 * @modifier
 * @date
 * @since 17/2/8 下午7:38
 */
public class IOSViewProvider extends ItemViewProvider<GankBean, IOSViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_ios, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull GankBean gankBean) {
        holder.tvTitle.setText(gankBean.desc());
        holder.tvAuthor.setText(gankBean.who());
        holder.tvTime.setText(gankBean.createAt());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_android_icon)
        ImageView ivAndroidIcon;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.tv_time)
        TextView tvTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
