package com.my61.oneclick.main;


import javax.crypto.spec.IvParameterSpec;

import com.my61.oneclick.func.AirplaneMode;
import com.my61.oneclick.func.Bluetooth;
import com.my61.oneclick.func.DataSwitch;
import com.my61.oneclick.func.FlashLight;
import com.my61.oneclick.func.GotoSettings;
import com.my61.oneclick.func.GpsSwitch;
import com.my61.oneclick.func.LockOff;
import com.my61.oneclick.func.RotateSwitch;
import com.my61.oneclick.func.SilentSwitch;
import com.my61.oneclick.func.VibrateSwitch;
import com.my61.oneclick.func.WifiSwitch;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BigFloatWindow extends LinearLayout {
	
	/**
	 * 记录大悬浮窗的宽度
	 */
	public static int viewWidth;

	/**
	 * 记录大悬浮窗的高度
	 */
	public static int viewHeight;
	
	
	LayoutInflater infalter;

	
	public BigFloatWindow( Context context) {
		super(context);
		LayoutInflater.from(context).inflate(R.layout.big_floatwindow, this);
		
		View view  = findViewById(R.id.big_window_layout);
		
		GridView gridView;
		gridView = (GridView)this.findViewById(R.id.gridview);
		
		gridView.setAdapter(new GridViewAdapter(this, context));
		
		gridView.setOnItemClickListener( new GridItemClickListener());
		
		viewWidth  = view.getLayoutParams().width;
		viewHeight = view.getLayoutParams().height;
		

		
		
	}
	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		/**
		 * 点击 大悬浮窗 以外的地方，则关闭 大悬浮窗 并且显示 小悬浮窗
		 */
		
		if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {

				MyWindowManager.removeBigWindow(getContext() );
				MyWindowManager.createSmallWindow(getContext() );
				}
		
		return false;
}

	
	//实例化
	WifiSwitch wifiSwitch = new WifiSwitch();
	DataSwitch dataSwitch = new DataSwitch();
	GpsSwitch gpsSwitch = new GpsSwitch();
	Bluetooth bluetooth = new Bluetooth();
	
	LockOff lockOff = new LockOff();
	
	FlashLight flashLight = new FlashLight();
	RotateSwitch rotateSwitch = new RotateSwitch();
	SilentSwitch silentSwitch = new SilentSwitch();
	VibrateSwitch vibrateSwitch = new VibrateSwitch();
		
	
	
	private class GridItemClickListener implements OnItemClickListener {  
        /** 
         * @param parent 代表当前的gridview  
         * @param view 代表点击的item 
         * @param position 当前点击的item在适配器中的位置  
         * @param id 当前点击的item在哪一行 
         */  
		
		
		@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  
            
			switch (position) {
			
	            case 0:  
	            	//wifi
	            	
	            	wifiSwitch.OnClick(getContext() );
	            break;
	            
	            	
	            case 1:
	            	//data switch
	            	
	            	dataSwitch.OnClick(view.getContext());
	            break;	
	            
	            	
	            case 2:
	            	//GPS switch
	            	
	            	gpsSwitch.OnClick(getContext());
	            break;
	            
	            	
	            case 3:
	            	//Bluetooth
	            	
	            	bluetooth.OnClick(getContext());
	            	
	            break;
	            	
	            
	            case 4:
	            	//Lock off
	            	
/*	            	//Activity currentActivity = (Activity) view.getContext();
	            	Intent intent = new Intent();
	            	intent.setClass(view.getContext(), LockOff.class);
	            	view.getContext().startActivity(intent);*/
	            	
	            	
	            	
	            	
	            break;      	
	            	
	            
	            case 5:
	            	//Ligth switch
	            	
	            	flashLight.OnClick();
	            	
	            break;
	            	
	            	
	            case 6:
	            	//Rotate
	            	
	            	rotateSwitch.onClick(getContext());
	            	
	            break;
	            	
	            	
	            	
	            case 7:
	            	//SilentMode
	            	
	            	silentSwitch.OnClick(getContext());
	            break;
	            	
	            
	            case 8:
	            	//Vibrate
	            	
	            	vibrateSwitch.OnClick(getContext());
	            break;
	            	
	            	
	            default:	
                break;  
            }  
        }  
		
    }  
	


}

