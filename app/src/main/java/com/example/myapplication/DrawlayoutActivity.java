package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dd on 2017/3/28.
 */

public class DrawlayoutActivity extends AppCompatActivity {

    private ClickableSlidingDrawer myDrawer;
    private RelativeLayout myImageView;
    private RelativeLayout myGridView;
    private TextView bt_text;
    private TextView bt_text2;
    private TextView bt_text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);
        myDrawer = (ClickableSlidingDrawer) findViewById(R.id.drawer);
        myImageView = (RelativeLayout) findViewById(R.id.handle);
        myGridView = (RelativeLayout) findViewById(R.id.content);
        bt_text = (TextView) findViewById(R.id.bt_text1);
        bt_text2 = (TextView) findViewById(R.id.bt_text2);
        bt_text3 = (TextView) findViewById(R.id.bt_text3);

        bt_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DrawlayoutActivity.this, "点击了1", Toast.LENGTH_LONG).show();
            }
        });
        bt_text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DrawlayoutActivity.this, "点击了默认界面2", Toast.LENGTH_LONG).show();
            }
        });
        bt_text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DrawlayoutActivity.this, "点击了2", Toast.LENGTH_LONG).show();
            }
        });
        myDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                bt_text2.setVisibility(View.GONE);
            }
        });

        myDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                bt_text2.setVisibility(View.VISIBLE);
            }
        });

        myDrawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener() {
            @Override
            public void onScrollStarted() {
                bt_text2.setVisibility(View.GONE);
            }

            @Override
            public void onScrollEnded() {

            }
        });

    }
}
