package com.my61.oneclick.main;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button startFloatWindowButton = (Button)findViewById(R.id.start_floatwindow);
		
		Button closeFloatWindowButton = (Button)findViewById(R.id.close_floatwindow);
		
		startFloatWindowButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, FloatWindowService.class);
				startService(intent);
				
				finish();
			}
		});
		
		closeFloatWindowButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 点击关闭悬浮窗的时候，移除所有悬浮窗，并停止Service
				
				MyWindowManager.removeBigWindow(getApplicationContext() );
				MyWindowManager.removeSmallWindow(getApplicationContext() );
				Intent intent = new Intent(getApplicationContext(), FloatWindowService.class);
				getApplicationContext().stopService(intent);
				
				finish();
			}
		});
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

}
