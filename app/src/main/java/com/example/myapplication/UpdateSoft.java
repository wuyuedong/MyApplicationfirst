package com.example.myapplication;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.widget.RemoteViews;

/**
 * @author
 * @describe 更新app
 * @date 2017-3-15 下午2:43:57
 */
public class UpdateSoft {

    private Activity activity;
    private UpdateDialog dialog; // 版本提示框
//    private UpdateBean bean;
//    private UpdateBean.UpdateSonBean apk;


    private Notification notification;
    private NotificationManager mNotificationManager;
    private RemoteViews views;

    public UpdateSoft(Activity activity) {
        this.activity = activity;
    }

    /**
     * 更新
     */
    public void update() {

//        OkGo.post(UrlContent.URL_UPDATE).execute(new StringCallback() {
//            @Override
//            public void onSuccess(String s, Call call, Response response) {
//                bean = new Gson().fromJson(s, UpdateBean.class);
//                if (bean.getErrmsg().equals("success")) {
//                    apk = bean.getVersion().get(0);
//                    if (!apk.getVersion().equals(SystemInfo.getVersionChars())) {
//                        showNew();
//                    }
//                }
//            }
//        });
    }


    // 显示新版本信息
    public void showNew() {

//

        dialog = new UpdateDialog(activity, new OnDialogListener() {

            @Override
            public void onOK() {
//                downLoad();
                dialog.dismiss();
            }

            @Override
            public void onCancle() {
//                if (apk.getForce() == 1) {
//                    activity.finish();
//                }
            }
        });
        dialog.setTitle("版本更新啦，提高用户体验")
//                .setText(apk.getMessage())
                .setGravityLeft()
                .setButton("忽略", "更新")
                .show();
    }

//    // 下载
//    private void downLoad() {
//        // 定义NotificationManager
//        mNotificationManager = (NotificationManager) activity
//                .getSystemService(Context.NOTIFICATION_SERVICE);
//        // 定义通知栏展现的内容信息
//        notification = new Notification();
//        notification.icon = R.mipmap.ico_about_my;
//        notification.tickerText = "正在下载...";
//        notification.when = System.currentTimeMillis();
//        views = new RemoteViews(activity.getPackageName(),
//                R.layout.download_layout);
//        notification.contentView = views;
//        notification.contentView.setTextViewText(R.id.apkname,
//                activity.getString(R.string.app_name));
//        notification.contentView.setTextViewText(R.id.progress_tv, "0%");
//        notification.contentView.setProgressBar(R.id.progressBar1, 100, 0,
//                false);
//        // 定义下拉通知栏时要展现的内容信息
//        Intent notificationIntent = new Intent();
//        PendingIntent contentIntent = PendingIntent.getActivity(activity, 0,
//                notificationIntent, 0);
//        notification.contentIntent = contentIntent;
//
//        // 用mNotificationManager的notify方法通知用户生成标题栏消息通知
//        mNotificationManager.notify(0x601, notification);
//
//        OkGo.post("http://7xrsez.com1.z0.glb.clouddn.com/MGG-3.5.1.apk").execute(new FileCallback(UrlContent.CACHE_FILE, UrlContent.APK_NAME) {
//            @Override
//            public void onSuccess(File file, Call call, Response response) {
//                mNotificationManager.cancel(0x601);
//                Uri uri = Uri.fromFile(file);
//                Intent installIntent = new Intent(Intent.ACTION_VIEW);
//                installIntent.setDataAndType(uri,
//                        "application/vnd.android.package-archive");
//                installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                activity.startActivity(installIntent);
//            }
//
//            @Override
//            public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
//
//                int process = 0;
//                int pro = (int) (progress * 100);
//                if (pro - process >= 2) {
//                    process = pro;
//                }
//
//                notification.contentView.setTextViewText(
//                        R.id.progress_tv, process + "%");
//                notification.contentView.setProgressBar(
//                        R.id.progressBar1, 100, process, false);
//                notification.contentView = views;
//                mNotificationManager.notify(0x601, notification);
//            }
//
//            @Override
//            public void onError(Call call, Response response, Exception e) {
//
//                mNotificationManager.cancel(0x601);
//                Notification notification = new Notification();
//                notification.icon = R.mipmap.ico_ar;
//                notification.tickerText = "下载失败";
//                notification.when = System.currentTimeMillis();
//                notification.defaults = Notification.DEFAULT_SOUND;// 铃声提醒
////						notification.setLatestEventInfo(activity, "下载失败",
////								"下载失败,请重新下载", null);
//                notification.flags = Notification.FLAG_AUTO_CANCEL;// 点击后自动消失
//                mNotificationManager.notify(0x602, notification);
//            }
//        });
//    }

}
