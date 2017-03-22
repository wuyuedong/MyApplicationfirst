package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * description 首页功能模块适配器
 * Created by dd on 16/5/26.
 */
public class MainAppAdapter extends BaseAdapter {

    private ArrayList<HotOrGoodBean.HotOrGoodSonBean.HotOrGoodSonSonBean> list = null;
    private Context context;


    public MainAppAdapter(Context context,ArrayList<HotOrGoodBean.HotOrGoodSonBean.HotOrGoodSonSonBean> list) {
        this.context = context;
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
        ViewHolder vh = null;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_youzhi_tuijian, null);
            vh.hot_shangping_name = (TextView) convertView.findViewById(R.id.hot_shangping_name);
            vh.hot_shangping_price = (TextView) convertView.findViewById(R.id.hot_shangping_price);
            vh.hot_shangping_collect = (TextView) convertView.findViewById(R.id.hot_shangping_collect);

            vh.functionImage = (ImageView) convertView.findViewById(R.id.hot_shagnping_img);

            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.setData(list.get(position), position, list.size());

        return convertView;
    }

    private class ViewHolder {

        TextView hot_shangping_name; // 功能标题
        TextView hot_shangping_price; // 功能标题
        TextView hot_shangping_collect; // 功能标题


        ImageView functionImage; // 功能图标

        public void setData(HotOrGoodBean.HotOrGoodSonBean.HotOrGoodSonSonBean item, int position, int size) {
            hot_shangping_name.setText(item.getName());
            hot_shangping_price.setText(item.getPrice());
            hot_shangping_collect.setText(item.getStars());
            Glide.with(context).load(item.getIcon()).into(functionImage);


        }
    }
}
