package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Song on 2017/3/29.
 */

public class TuwenxiangqingActivity extends AppCompatActivity {


    private static final int PAGE_LIMIT = 2;
    public TabLayout mtabLayout;
    public NoScrollViewPager viewPager;
    public ScrollViewContainer scrollViewContainer;
    private IsTopBottomScrollView second_scrollview;
    private ImageView imageView;
    IsTopBottomScrollView first_scrollew;

    private MyListview listview;
    int height = 0;
    //Tab 文字
    private final int[] TAB_TITLES = new int[]{R.string.shouye, R.string.classification};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);


//        mtabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        viewPager = (NoScrollViewPager) findViewById(R.id.viewpager);
        second_scrollview = (IsTopBottomScrollView) findViewById(R.id.second_scrollview);
        first_scrollew = (IsTopBottomScrollView) findViewById(R.id.scrollview);
        imageView = (ImageView) findViewById(R.id.image);
        listview = (MyListview) findViewById(R.id.mylistview);
        BianminFuAdapter adapter =  new BianminFuAdapter(getData());
        listview.setAdapter(adapter);


//        List<Fragment> fragments = new ArrayList<>();
//        fragments.add(new OrderFragment());//首页
//        fragments.add(new OrderFragment2());//订单
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
//        viewPager.setAdapter(adapter);
//        viewPager.setNoScroll(false);
//        viewPager.setOffscreenPageLimit(PAGE_LIMIT);
//        mtabLayout.setupWithViewPager(viewPager);
//        for (int i = 0; i < mtabLayout.getTabCount(); i++) {
//            TabLayout.Tab tab = mtabLayout.getTabAt(i);
//
//            if (tab != null) {
////                tab.setIcon(drawable);
//                tab.setText(TAB_TITLES[i]);
//            }
//        }
//        first_scrollew.setScanScrollChangedListener(new IsTopBottomScrollView.ISmartScrollChangedListener() {
//            @Override
//            public void onScrolledToBottom() {
//                CLToastUtil.show(TuwenxiangqingActivity.this, "底部1");
//                imageView.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onScrolledToTop() {
//                CLToastUtil.show(TuwenxiangqingActivity.this, "顶部1");
//                imageView.setVisibility(View.VISIBLE);
//
//            }
//        });
//
//        second_scrollview.setScanScrollChangedListener(new IsTopBottomScrollView.ISmartScrollChangedListener() {
//            @Override
//            public void onScrolledToBottom() {
//                CLToastUtil.show(TuwenxiangqingActivity.this, "底部2");
//                imageView.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onScrolledToTop() {
//                CLToastUtil.show(TuwenxiangqingActivity.this, "顶部2");
//                imageView.setVisibility(View.INVISIBLE);
//            }
//        });

    }

    public ArrayList<String> getData(){
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<35;i++){
            list.add("ceshi"+i);
        }
        return list;
    }

     class BianminFuAdapter extends BaseAdapter {

        private ArrayList<String> list = null;

        public BianminFuAdapter(ArrayList<String> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(TuwenxiangqingActivity.this);
            textView.setText(list.get(position));
            return textView;
        }


    }
}
