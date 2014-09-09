package com.my61.oneclick.func;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class GpsSwitch {
	
	public void OnClick(Context context) {
		
		Intent intent_gps = new Intent();
		intent_gps.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
		//利用java反射功能，发送广播：
		
		intent_gps.addCategory("android.intent.category.ALTERNATIVE");
		
		intent_gps.setData(Uri.parse("custom:3"));
		//其中WIFI：0；背光高度：1；同步数据：2；GPS：3；蓝牙：4
		try {
			PendingIntent.getBroadcast(context, 0, intent_gps, 0).send();
		} catch (CanceledException e) {
			e.printStackTrace();
		}
	}

}
