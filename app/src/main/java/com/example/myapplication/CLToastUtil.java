package com.example.myapplication;

import android.content.Context;
import android.widget.Toast;

public class CLToastUtil {

	private static Toast sToast = null;

	public static void showLong(Context context, CharSequence text) {
		if (sToast == null) {
			sToast = Toast.makeText(context, text, Toast.LENGTH_LONG);
		} else {
			sToast.setText(text);
			sToast.setDuration(Toast.LENGTH_LONG);
		}
		sToast.show();
	}

	public static void showLong(Context context, int resId) {
		if (sToast == null) {
			sToast = Toast.makeText(context, resId, Toast.LENGTH_LONG);
		} else {
			sToast.setText(resId);
			sToast.setDuration(Toast.LENGTH_LONG);
		}
		sToast.show();
	}

	public static void showShort(Context context, CharSequence text) {
		if (sToast == null) {
			sToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		} else {
			sToast.setText(text);
			sToast.setDuration(Toast.LENGTH_SHORT);
		}
		sToast.show();
	}

	public static void showShort(Context context, int resId) {
		if (sToast == null) {
			sToast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
		} else {
			sToast.setText(resId);
			sToast.setDuration(Toast.LENGTH_SHORT);
		}
		sToast.show();
	}

	public static void show(Context context, CharSequence text) {
		if (sToast == null) {
			sToast = Toast.makeText(context, text, Toast.LENGTH_LONG);
		} else {
			sToast.setText(text);
			sToast.setDuration(Toast.LENGTH_SHORT);
		}
		sToast.show();
	}

	/**
	 * 取消 ，建议在onPause()中调用
	 */
	public static void cancel() {
		if (sToast != null) {
			sToast.cancel();
		}
	}
	
}