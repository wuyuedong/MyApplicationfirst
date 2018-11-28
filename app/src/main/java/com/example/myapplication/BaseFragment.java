package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzy.okgo.OkGo;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dongdong on 2017/3/2.
 */

public abstract class BaseFragment extends Fragment {
    public App appContext;
    protected Activity context;
    private Handler handler = new Handler();
    private Runnable loadDataTask = new Runnable() {
        @Override
        public void run() {
            loadData();  
        }
    };
    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView();
        initEvent();
        // 延迟加载数据，减少卡顿
        handler.postDelayed(loadDataTask, 500);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser) {
            handler.removeCallbacks(loadDataTask);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        appContext = (App) getActivity().getApplication();
        this.context = getActivity();
    }

    @Override
    public void onPause() {
        super.onPause();
//        CLToastUtil.cancel();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelTag(getActivity());
    }
//
//    public void showToast(CharSequence text) {
//        CLToastUtil.showShort(appContext, text);
//    }
//
//    public void showToast(int resId) {
//        CLToastUtil.showShort(appContext, resId);
//    }
//
//    private Dialog dialog = null;
//
//    public void showLoading() {
//        if (dialog == null) {
//            dialog = new Dialog(context, R.style.AlertDialogIOSStyle);
//            View view = LayoutInflater.from(context).inflate(R.layout.loading_dialog, null);
//            view.findViewById(R.id.loading).setVisibility(View.VISIBLE);
//            dialog.setContentView(view);
//            dialog.setCancelable(false);
//        }
//        dialog.show();
//    }
//
//    public void closeLoading() {
//        if (dialog != null && dialog.isShowing()) {
//            dialog.dismiss();
//        }
//    }

//    protected void initRefreshLayout(BGARefreshLayout refreshLayout) {
//        // 设置下拉刷新和上拉加载更多的风格 参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
//        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getActivity(), true);
//        // 设置下拉刷新和上拉加载更多的风格
//        refreshLayout.setRefreshViewHolder(refreshViewHolder);
//
//        // 为了增加下拉刷新头部和加载更多的通用性，提供了以下可选配置选项 -------------START
//        // 设置正在加载更多时不显示加载更多控件
//        refreshLayout.setIsShowLoadingMoreView(true);
//        // 设置正在加载更多时的文本
//        refreshViewHolder.setLoadingMoreText("加载更多");
//        // // 设置整个加载更多控件的背景颜色资源id
//        // refreshViewHolder.setLoadMoreBackgroundColorRes(loadMoreBackgroundColorRes);
//        // // 设置整个加载更多控件的背景drawable资源id
//        // refreshViewHolder.setLoadMoreBackgroundDrawableRes(loadMoreBackgroundDrawableRes);
//        // // 设置下拉刷新控件的背景颜色资源id
//        // refreshViewHolder.setRefreshViewBackgroundColorRes(refreshViewBackgroundColorRes);
//        // // 设置下拉刷新控件的背景drawable资源id
//        // refreshViewHolder.setRefreshViewBackgroundDrawableRes(refreshViewBackgroundDrawableRes);
//        // // 设置自定义头部视图（也可以不用设置） 参数1：自定义头部视图（例如广告位）， 参数2：上拉加载更多是否可用
//        // refreshLayout.setCustomHeaderView(mBanner, false);
//
//    }

    protected abstract void initView();

    protected abstract void initEvent();

    protected abstract void loadData();

    protected abstract int getLayoutId();


}
