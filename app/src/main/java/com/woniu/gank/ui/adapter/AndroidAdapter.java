package com.woniu.gank.ui.adapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.woniu.gank.R;
import com.woniu.gank.data.bean.GankBean;
import com.woniu.gank.ui.navigation.Navigator;

import javax.inject.Inject;

/**
 * @author woniu
 * @title AndroidAdapter
 * @description 在android中由于adapter一般是做数据和view的绑定的，说以他使用dagger2管理的时候，应该是
 * 注入几次就生成几个实例，而不能是用自定义的@Scope注解让它在某一作用域中保持单例，因为它的职责决定了它不应该被多个
 * activity或者fragment共享，也许有人会说adapter只会在某个对应的activity或者fragment中被注入，所以加
 * 自定义的@Scope并不影响，但是这里推荐还是不要加，因为如果出现此adapter在多个activity或者fragment中复
 * 用的时候，不加自定义@Scope能正确使用，但是加了自定义@Scope的话，就有可能出错
 * 【总之，最好永远也不要给adapter添加任何@Scope】
 * @modifier
 * @date
 * @since 16/11/8 下午10:49
 */
public class AndroidAdapter extends BaseAdapter<GankBean, BaseViewHolder> {

    @Inject
    Navigator mNavigator;

    @Inject
    public AndroidAdapter() {
        super(R.layout.item_android, null);
    }

    @Override
    protected void convert(BaseViewHolder holder, GankBean gankBean) {
        holder.setText(R.id.tv_title, gankBean.desc())
                .setText(R.id.tv_author, gankBean.who())
                .setText(R.id.tv_time, gankBean.createAt());
        mNavigator.log(holder.getAdapterPosition());
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
