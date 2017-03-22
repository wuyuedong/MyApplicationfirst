package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;



/**
 * @describe 自定义Dialog
 * @author dd
 * @date 2017-3-17 下午1:41:00
 */
public class UpdateDialog implements OnClickListener {

	private Dialog dialog = null;
	private Context context = null;
	private OnDialogListener listener = null;

	private TextView titleView;
	private TextView msgView;
	private Button btnNeg;
	private Button btnPos;
	private ImageView lineView;

	public UpdateDialog(Context context, OnDialogListener listener) {
		this.context = context;
		this.listener = listener;
		builder();
	}

	public void show() {
		dialog.show();
	}

	public void dismiss() {
		dialog.dismiss();
	}

	public UpdateDialog setTitle(String title) {
		titleView.setText(title);
		titleView.setVisibility(View.VISIBLE);
		return this;
	}

	public UpdateDialog setText(String msg) {
		msgView.setText(msg);
		msgView.setVisibility(View.VISIBLE);
		return this;
	}

	/**
	 * 更新时候使用，文字靠左
	 * @return
	 */
	public UpdateDialog setGravityLeft() {
		msgView.setGravity(Gravity.LEFT);
		return this;
	}

	public UpdateDialog setButton(String ngtxt, String potxt) {
		if (ngtxt != null && potxt != null) {
			lineView.setVisibility(View.VISIBLE);
		}
		if (ngtxt != null) {
			btnNeg.setText(ngtxt);
			btnNeg.setVisibility(View.VISIBLE);
		}
		if (potxt != null) {
			btnPos.setText(potxt);
			btnPos.setVisibility(View.VISIBLE);
		}
		return this;
	}



	private void builder() {
		dialog = new Dialog(context, R.style.AppTheme);
		// 获取Dialog布局
		View view = LayoutInflater.from(context).inflate(
				R.layout.dialog_update, null);

		dialog.setContentView(view);

		// 获取自定义Dialog布局中的控件
		FrameLayout lLayout_bg = (FrameLayout) view
				.findViewById(R.id.lLayout_bg);
		titleView = (TextView) view.findViewById(R.id.txt_title);
		titleView.setVisibility(View.GONE);

		msgView = (TextView) view.findViewById(R.id.txt_msg);
		msgView.setVisibility(View.GONE);


		btnNeg = (Button) view.findViewById(R.id.btn_neg);
		btnNeg.setVisibility(View.GONE);
		btnNeg.setOnClickListener(this);

		btnPos = (Button) view.findViewById(R.id.btn_pos);
		btnPos.setVisibility(View.GONE);
		btnPos.setOnClickListener(this);

		lineView = (ImageView) view.findViewById(R.id.img_line);
		lineView.setVisibility(View.GONE);

		// 调整dialog背景大小
//		lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams(
//				(int) (ScreenUtils.getInstance().getScreenWidth() * 0.8),
//				LayoutParams.WRAP_CONTENT));
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.btn_neg:
			dialog.dismiss();
			listener.onCancle();
			break;
		case R.id.btn_pos:
			listener.onOK();
			break;

		default:
			break;
		}
	}

}
