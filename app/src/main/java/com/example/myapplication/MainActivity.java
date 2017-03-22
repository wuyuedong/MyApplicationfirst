package com.example.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

import static android.view.View.OVER_SCROLL_NEVER;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    /**
     * 功能模块数据
     */
    private float pageSize = 4.0f; // 每页显示8个分类APP数据
    private ArrayList<GridView> app_GridViews; // 功能选项显示
    private ViewPager functionVP;
    private ArrayList<ImageView> posFunctions; // 功能分页标记
    private LinearLayout functionVPBJ; // 功能分页指示器
    private int line = 2;
    private int colNum = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new UpdateSoft(this).showNew();

        posFunctions = new ArrayList<>();
        functionVP = (ViewPager) findViewById(R.id.functionVP);
        functionVP.setOverScrollMode(OVER_SCROLL_NEVER);
        functionVPBJ = (LinearLayout) findViewById(R.id.functionVPBJ);

        initData();
    }

    private void initData() {
        OkGo.post("http://121.40.201.50:8000/ar/goods/sellingGoodsList")
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        HotOrGoodBean bean = new Gson().fromJson(s, HotOrGoodBean.class);
                        if (bean.getErrmsg().equals("success")) {
                            setPageAdapterData(bean.getMap().getList());
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {

                    }
                });
    }

    /**
     * 设置首页功能模块显示
     *
     * @param list
     */
    public void setPageAdapterData(final ArrayList<HotOrGoodBean.HotOrGoodSonBean.HotOrGoodSonSonBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        app_GridViews = new ArrayList<>();
        // 可分的页数
        int page = (int) Math.ceil(list.size() / pageSize);
        for (int i = 0; i < page; i++) {
            GridView gv = new GridView(this);
            gv.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            gv.setNumColumns(colNum);
            gv.setVerticalScrollBarEnabled(true);
            gv.setOverScrollMode(OVER_SCROLL_NEVER);
            gv.setCacheColorHint(Color.TRANSPARENT);
            gv.setSelector(new ColorDrawable(Color.TRANSPARENT));
            final ArrayList<HotOrGoodBean.HotOrGoodSonBean.HotOrGoodSonSonBean> li = new ArrayList<>();
            if (i == page - 1) {
                li.addAll(list.subList(i * colNum * line, list.size()));
            } else {
                li.addAll(list.subList(i * colNum * line, i * colNum * line + colNum * line));
            }
            MainAppAdapter adapter = new MainAppAdapter(this, li);
            gv.setAdapter(adapter);
            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Toast.makeText(MainActivity.this, "" + li.get(position).getName(), Toast.LENGTH_LONG).show();
                }
            });
            app_GridViews.add(gv);
        }

        functionVP.setAdapter(new FunctionAdapter(app_GridViews));
        setFunctionHeight(app_GridViews.get(0));
        functionVP.setVisibility(VISIBLE);

        /**
         * 设置指示器
         */
        if (page <= 1) { // 不需要分页
            return;
        }
        if (posFunctions.size()!=0){
            posFunctions.clear();
        }
        functionVPBJ.removeAllViews();
        functionVPBJ.setVisibility(VISIBLE);
        // 显示标签
        for (int i = 0; i < page; i++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 10;
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            if (i == 0) {
                imageView.setImageResource(R.mipmap.ico_appselect);
            } else {
                imageView.setImageResource(R.mipmap.ico_appunselect);
            }
            functionVPBJ.addView(imageView);
            posFunctions.add(imageView);
        }
//        currentFunPage = 0;
        functionVP.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < posFunctions.size(); i++) {
                    if (i == position) {
                        // 修改当前为选中
                        posFunctions.get(i).setImageResource(R.mipmap.ico_appselect);
                    } else {
                        // 修改之前的未选中
                        posFunctions.get(i).setImageResource(R.mipmap.ico_appunselect);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setFunctionHeight(GridView listView) {
        // 获取listview的adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        // 固定列宽，有多少列
        int col = colNum;
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i += col) {
            // 获取listview的每一个item
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            // 获取item的高度和
            totalHeight += listItem.getMeasuredHeight();
        }

        // 获取listview的布局参数
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // 设置高度
        params.height = totalHeight;
        // 设置参数
        listView.setLayoutParams(params);
        ViewGroup.LayoutParams params1 = functionVP.getLayoutParams();
        params1.height = totalHeight + functionVP.getPaddingTop() + functionVP.getPaddingBottom();
        functionVP.setLayoutParams(params1);
    }


    /**
     * 功能适配器
     */
    class FunctionAdapter extends PagerAdapter {

        private ArrayList<GridView> app_GridViews;

        public FunctionAdapter(ArrayList<GridView> app_GridViews) {
            this.app_GridViews = app_GridViews;
        }

        @Override
        public int getCount() {
            if (app_GridViews == null) {
                return 0;
            }
            return app_GridViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(app_GridViews.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(app_GridViews.get(position), 0);
            return app_GridViews.get(position);
        }
    }
}
