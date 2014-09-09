package com.my61.oneclick.func;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Bluetooth {
	
	public void OnClick(Context context) {
		
		Intent intent_bt = new Intent();
		intent_bt.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
		//利用java反射功能，发送广播：
		
		intent_bt.addCategory("android.intent.category.ALTERNATIVE");
		
		intent_bt.setData(Uri.parse("custom:4"));
		
		//其中WIFI：0；背光高度：1；同步数据：2；GPS：3；蓝牙：4
		try {
			PendingIntent.getBroadcast(context, 0, intent_bt, 0).send();
		} catch (CanceledException e) {
			e.printStackTrace();
		}
	}

}
